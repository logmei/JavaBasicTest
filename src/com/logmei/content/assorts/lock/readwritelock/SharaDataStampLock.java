package com.logmei.content.assorts.lock.readwritelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 16:06 2019/1/24
 * @ Description：读写锁的使用
 * @ Modified By：
 * @Version: 1.0.0
 */
public class SharaDataStampLock {
    //定义共享资源
    private final List<Character> container = new ArrayList<>();

    private final StampedLock stampedLock = new StampedLock();

    private final int length;

    public SharaDataStampLock(int length) {
        this.length = length;
        for (int i = 0; i < length;i++){
            container.add('c');
        }
    }

    public char[] read() throws InterruptedException{
        /*long stamp = stampedLock.tryOptimisticRead();//试图尝试乐观锁，返回类似时间戳的返回值作为凭证
        char[] newBuffer = readCont();
        if(!stampedLock.validate(stamp)){//判断在读的过程中被修改过，如果没被修改过则有效，可以返回，反正stamp不可用。解决办法可以向CAS循环使用乐观锁直到成功为止
            try {
                stamp = stampedLock.readLock();//可以升级乐观锁为悲观锁，读锁的申请导致线程挂起
                newBuffer = readCont();
                slowly();
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }else {
            slowly();
        }*/


        while (true) {
            long stamp = stampedLock.tryOptimisticRead();//试图尝试乐观锁，返回类似时间戳的返回值作为凭证
            char[] newBuffer = readCont();
            if(!stampedLock.validate(stamp)) {
                slowly();
                return newBuffer;
            }
        }
    }

    private char[] readCont(){
        char[] newBuffer = new char[length];
        for (int i = 0;i < length ; i++){
            newBuffer[i] = container.get(i);
        }
        return newBuffer;
    }

    public void write(char c) throws InterruptedException{
        long stamp = stampedLock.writeLock();
        try{

            for (int i = 0;i<length;i++){
                this.container.add(i,c);
            }
            slowly();
        }finally {
            stampedLock.unlockWrite(stamp);
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
