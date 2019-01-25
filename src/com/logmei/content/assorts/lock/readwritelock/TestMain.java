package com.logmei.content.assorts.lock.readwritelock;

import java.util.stream.IntStream;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 16:58 2019/1/24
 * @ Description：测试读写锁
 * @ Modified By：
 * @Version: 1.0.0
 */
public class TestMain {
    private final static String text = "Thisistheexampleforreadwritelock";
    public static void main(String[] args){
        final SharaDataStampLock sharaData = new SharaDataStampLock(50);
        //创建两个线程进行数据写操作
        IntStream.range(0,2).forEach(i->{
            new Thread(()->{
                for (int index = 0 ;index < text.length();index++){
                    char c = text.charAt(index);
                    try {
                        sharaData.write(c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.format("%s write %s\n", Thread.currentThread(),c);
                }

            }).start();
        });

        //创建10个线程进行数据的读操作
        IntStream.range(0,10).forEach(i->{
            new Thread(()->{
                while (true) {
                    try {
                       System.out.format("%s read %s\n",Thread.currentThread(),new String(sharaData.read())) ;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}
