package com.logmei.content.assorts.thread.executorService;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaThreadPoolTest  {
    public static void main(String[] args){
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(5);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,queue);
        for (int i=0;i<16;i++){
            poolExecutor.execute(()->{
                System.out.println("线程池中活跃的线程数： " + poolExecutor.getPoolSize());
                 if (queue.size() > 0)
                  {
                           System.out.println("----------------队列中阻塞的线程数" + queue.size());
                   }

            });
        }
        poolExecutor.shutdown();
    }
}
