package com.logmei.content.assorts.thread.executorService;

public class InternalTask implements Runnable {
    //任务队列
    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //如果当前任务为running并且没有被中断，则其不断的从RunnableQueue中取Runnable,然后执行run方法
        while (running&&!Thread.currentThread().isInterrupted()){
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                running = false;
                break;
            }
        }

    }

    //停止当前任务
    public void stop(){
        this.running = false;
    }
}
