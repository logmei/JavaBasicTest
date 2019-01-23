package com.logmei.content.assorts.thread.executorService;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {

    private final LinkedList<Runnable> runableList = new LinkedList<>();
    private final int limit;//队列的最大容量
    private final ThreadPool threadPool;
    private final DenyPolicy denyPolicy;

    public LinkedRunnableQueue(int limit,ThreadPool threadPool,DenyPolicy denyPolicy) {
        this.limit = limit;
        this.threadPool = threadPool;
        this.denyPolicy = denyPolicy;
    }

    @Override
    public void offer(Runnable runnable) throws InterruptedException {

        synchronized (runableList){
            //System.out.println("LinkedRunnableQueue offer runnableList size:"+runableList.size()+";limit:"+limit);
            //System.out.println("LinkedRunnableQueue offer pool core size:"+threadPool.getCoreSize()+";limit:"+limit);
            while (runableList.size()> limit) {
                    denyPolicy.reject(runnable,threadPool);
            }
            runableList.addLast(runnable);
            runableList.notifyAll();
        }
    }

    @Override
    public Runnable take() throws InterruptedException{

        synchronized (runableList){
            //System.out.println("---------------------LinkedRunnableQueue take runnableList size:"+runableList.size()+";limit:"+limit);
            //System.out.println("---------------------LinkedRunnableQueue take pool core size:"+threadPool.getCoreSize()+";limit:"+limit);
            while (runableList.size() == 0) {
                try {
                    runableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            return runableList.removeFirst();

        }
    }

    @Override
    public int size() {
        return runableList.size();
    }
}
