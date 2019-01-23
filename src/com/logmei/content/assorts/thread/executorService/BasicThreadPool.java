package com.logmei.content.assorts.thread.executorService;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicThreadPool extends Thread implements ThreadPool {

    private final int initSize;

    private final int maxSize;

    private final int coreSize;

    private   int activeSize;
    //创建线程需要的工厂
    private final ThreadFactory threadFactory;
    //任务队列
    private final RunnableQueue runnableQueue;
    //线程池是否已经被关闭
    private volatile boolean isShutdown = false;

    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    //
    private int activeCount;

    private final long keepAliveTime;

    private final TimeUnit timeUnit;

    private final int queueSize;


    public BasicThreadPool(int initSize, int maxSize, int coreSize,
                           ThreadFactory threadFactory, int queueSize,
                           long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize,this,new DenyPolicy.DiscardDenyPolicy());
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.queueSize = queueSize;
        this.init();
    }

    public BasicThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
        this(initSize,maxSize,coreSize,new DefaultThreadFactory(),queueSize,10,TimeUnit.SECONDS);
    }

    //初始化时，先创建initSize个线程
    private void init(){
        start();
        for(int i=0;i<initSize;i++){
            newThread();
        }
    }
    //线程池自动维护
    private void newThread(){
        //创建任务线程并启动
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread,internalTask);
        threadQueue.offer(threadTask);
        this.activeCount++;
        thread.start();
    }

    private static class ThreadTask{
        public Thread thread;
        public InternalTask internalTask;

        public ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }
    }

    private void removeThread(){
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        this.activeCount--;
    }

    @Override
    public void excute(Runnable runnable) {

        if(this.isShutdown) throw new RunnableDenyException(DenyEnums.DONE);
        try {
            this.runnableQueue.offer(runnable);
            //System.out.println("runnablequeue offer queuesize :"+this.runnableQueue.size());
        } catch (InterruptedException e) {
            throw new RunnableDenyException(DenyEnums.WORK_INTERRUPT);
        }
    }

    @Override
    public void run() {
        while (!isShutdown && !isInterrupted()){
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutdown = true;
                break;
            }
            synchronized (this){
                if(isShutdown) break;
                //当前的队列中有任务尚未处理，并且activeCount<coreSize 则继续扩容
                if(runnableQueue.size()>0 && activeCount<coreSize){
                    for (int i = initSize;i<coreSize;i++){
                        newThread();
                    }
                    continue;//目的在于不想让线程的扩容直接达到maxSize
                }
                //当前的队列中有任务尚未处理，并且activeCont<maxsize则继续扩容
                if(runnableQueue.size()>0 && activeCount<maxSize){
                    for(int i=coreSize;i<maxSize;i++){
                        newThread();
                    }
                }
                //如果任务队列中没有任务，则需要回收，回收至coreSize即可
                if(runnableQueue.size() == 0 && activeCount>coreSize){
                    for (int i=coreSize;i<activeCount;i++){
                        removeThread();
                    }
                }
            }
        }
    }

    @Override
    public void shutdown() {
        synchronized (this){
            if(isShutdown)return;
            isShutdown = true;
            threadQueue.forEach(threadTask -> {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }

    }

    @Override
    public boolean isShutdown() {
        return this.isShutdown;
    }

    @Override
    public int getInitSize() {
        if(isShutdown)throw new RunnableDenyException(DenyEnums.DESTORYED);
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if(isShutdown) throw new RunnableDenyException(DenyEnums.DESTORYED);
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if(isShutdown) throw new RunnableDenyException(DenyEnums.DESTORYED);
        return this.coreSize;
    }

    @Override
    public int getQueueSize() {
        if(isShutdown) throw new RunnableDenyException(DenyEnums.DESTORYED);
        return this.runnableQueue.size();
    }

    @Override
    public int getActiveSize() {
        if(isShutdown) throw new RunnableDenyException(DenyEnums.DESTORYED);
        synchronized (this){
            return this.activeCount;
        }
    }

    private static class DefaultThreadFactory implements ThreadFactory{
        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
        private static final ThreadGroup group = new ThreadGroup("MyThreadPool-"+GROUP_COUNTER.getAndDecrement());
        private static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread createThread(Runnable runnable) {
            return new Thread(group,runnable,"thread-pool-"+COUNTER.getAndDecrement());
        }
    }
}
