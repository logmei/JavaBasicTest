package com.logmei.content.assorts.thread.waitnotify;

import java.util.concurrent.TimeUnit;

public class EventClient {
    public static void main(String[] args){
        final EventQueue eventQueue = new EventQueue(100);
        new Thread(()->{
            for (;;)
            eventQueue.offer(new EventQueue.Event());
        },"Producer").start();

        new Thread(()->{
           for (;;){
               eventQueue.take();
               try {
                   TimeUnit.MILLISECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"consumer").start();
    }
}
