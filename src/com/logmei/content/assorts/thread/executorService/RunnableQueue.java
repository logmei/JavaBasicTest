package com.logmei.content.assorts.thread.executorService;

public interface RunnableQueue {

    //有新的任务进来offer到队列中
    void offer(Runnable runnable) throws InterruptedException;
    //获取runnable
    Runnable take() throws InterruptedException;
    //获取任务队列中的任务数
    int size();
}
