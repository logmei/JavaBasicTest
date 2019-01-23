package com.logmei.content.assorts.thread.observable;

import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 11:02 2019/1/22
 * @ Description：测试
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ObservableMain {
    public static void main(String[] args){
       /* Observable observableThread = new ObservableThread<>(new Task<Object>() {
            @Override
            public Object call() {
                try{
                    TimeUnit.SECONDS.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(" finished done.");
                return null;
            }
        });*/
       Observable observableThread = new ObservableThread<>(()->{
           try {
               TimeUnit.SECONDS.sleep(10);
           } catch (InterruptedException e) {
               throw new ObservableException("线程被中断");
           }

           System.out.println(" finished is done");
           return null;
       });
       observableThread.start();
       observableThread.interrupt();


    }
}
