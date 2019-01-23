package com.logmei.content.assorts.thread.waitnotify;

import java.util.concurrent.TimeUnit;

public class SynchronizeDefect {

    public synchronized void syncMethod(){
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        SynchronizeDefect defect = new SynchronizeDefect();

        new Thread(defect::syncMethod,"T1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(defect::syncMethod,"T2");
        t2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}
