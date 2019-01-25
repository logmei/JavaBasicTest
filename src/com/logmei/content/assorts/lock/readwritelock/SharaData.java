package com.logmei.content.assorts.lock.readwritelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 16:06 2019/1/24
 * @ Description：读写锁的使用
 * @ Modified By：
 * @Version: 1.0.0
 */
public class SharaData {
    //定义共享资源
    private final List<Character> container = new ArrayList<>();
    //构造ReadWriteLock
    private final ReadWriteLock readWriteLock = ReadWriteLock.readWriteLock();
    //创建读取锁
    private final Lock readLock = readWriteLock.readLock();
    //创建写入锁
    private final Lock writeLock = readWriteLock.writeLock();

    private final int length;

    public SharaData(int length) {
        this.length = length;
        for (int i = 0; i < length;i++){
            container.add('c');
        }
    }

    public char[] read() throws InterruptedException{
        try{
            readLock.lock();
            char[] newBuffer = new char[length];
            for (int i = 0;i < length ; i++){
                newBuffer[i] = container.get(i);
            }
            slowly();
            return newBuffer;
        }finally {
            readLock.unlock();
        }
    }

    public void write(char c) throws InterruptedException{
        try{
            writeLock.lock();
            for (int i = 0;i<length;i++){
                this.container.add(i,c);
            }
            slowly();
        }finally {
            writeLock.unlock();
        }
    }

    //简单模拟操作的耗时
    private void slowly(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
