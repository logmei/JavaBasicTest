package com.logmei.content.assorts.thread.executorService;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException
    {
        //定义线程池，初始化线程数为2，核心线程数为4，最大线程数为6，任务队列最多运行1000个任务
        final ThreadPool threadPool = new BasicThreadPool(2,6,4,1000);
        for(int i=0;i<20;i++){
        threadPool.excute(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName()+" is running and done");
                System.out.println("threadPool.getCoreSize " + threadPool.getCoreSize());
                System.out.println("threadPool.getQueueSize " + threadPool.getQueueSize());
                System.out.println("threadPool.getActiveSize " + threadPool.getActiveSize());
                System.out.println("threadPool.getMaxSize" + threadPool.getMaxSize());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        }
            ;
    }
}
