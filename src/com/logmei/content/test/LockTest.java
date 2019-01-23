package com.logmei.content.test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args){

        for(int i = 0;i<10;i++){
            Thread thread = new Thread(new FairLock(),"fair"+i);
            thread.start();
        }
    }


    private static final ReentrantLock lock=new ReentrantLock(false);//true公平锁，false非公平锁
    public static class FairLock implements Runnable{
        @Override
        public void run() {
            System.out.println("当前锁："+Thread.currentThread().getName()+"已运行");
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获取锁");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }
    }
}
