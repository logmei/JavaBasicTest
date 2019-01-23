package com.logmei.content.test;


import com.logmei.content.assorts.designmodel.singleton.SingletonVolatileDoubleCheck;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class HelloWorld {
    public static  AtomicInteger countTest= new AtomicInteger(0);
    public static void main(String[] args){



       IntStream.range(0,1000).forEach(i->{
            new Thread(()->{
               SingletonVolatileDoubleCheck singleton = SingletonVolatileDoubleCheck.getInstance();

            }).start();
        });


    }
   static AtomicInteger count=new AtomicInteger(0);
    static int count2=0;

   static class CountThread extends Thread {
        @Override
        public void run() {
            synchronized (this) {
                while (count.intValue() < 100) {
                    count.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    try {
                         //Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
    static final ReentrantLock lock=new ReentrantLock(true);
    //static Condition condition=lock.newCondition();
    static class CountThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"线程启动");
                while (count2 < 100) {
                    try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"获取锁，执行代码");
                    if(count2<100){
                        count2++;
                        System.out.println(Thread.currentThread().getName() + ":" + count2);
                    }

                   /* try {
                        //Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {

                        lock.unlock();
                        System.out.println(Thread.currentThread().getName()+"锁关闭");
                    }
                }



        }

    }
}
