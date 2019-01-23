package com.logmei.content.assorts.thread.ThreadStudy;

import java.util.concurrent.TimeUnit;

public class ThreadSynchronized {
    private static final   Object MUTEX = new Object();
    public static int index = 0;

    public void accessResource(){

        try {
            synchronized(MUTEX){
                try {
                    TimeUnit.SECONDS.sleep(20);
                    System.out.println("当前线程名称["+(index++)+"]:"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+" enter to method1");
        try {
          //  while(true){
                System.out.println(Thread.currentThread().getName()+" enter to method1");
                TimeUnit.SECONDS.sleep(2);
           // }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2(){
        System.out.println((Thread.currentThread().getName()+" endter to method2"));
        try {
            while (true){
                System.out.println((Thread.currentThread().getName()+" endter to method2"));
                TimeUnit.SECONDS.sleep(2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        /*final ThreadSynchronized s = new ThreadSynchronized();
        for (int i = 0 ;i < 10 ;i ++ ){
            new Thread(s::accessResource).start();
        }*/
        new Thread(ThreadSynchronized::method1).start();
        new Thread(ThreadSynchronized::method2).start();
    }
}
