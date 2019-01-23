package com.logmei.content.assorts.thread.hook;


import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CaptureThreadException {
    public static void main(String[] args){

        //JVM中没有活跃非守护线程，JVM进程即将退出时，hook线程会被启动并且运行
        Runtime.getRuntime().addShutdownHook(new Thread(()->System.out.println("The hook Thread is running")));

        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
            System.out.println(t.getName()+"occur exception");
            e.printStackTrace();
        });

        IntStream.range(0,10).mapToObj(i->new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i="+i+";");
            if(i%2==0)
            System.out.println("i="+i+";"+(1/0));
        },"thread"+i)).forEach(Thread::start);




    }
}
