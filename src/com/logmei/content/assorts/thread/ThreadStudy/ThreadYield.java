package com.logmei.content.assorts.thread.ThreadStudy;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadYield {

    public static void main(String[] args){

        IntStream.range(0,5).mapToObj(ThreadYield::create).forEach(Thread::start);
    }
    private static Thread create(int index){
        return new Thread(()->{
            if(index==0){
                //Thread.yield();
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(index);
        });

    }
}
