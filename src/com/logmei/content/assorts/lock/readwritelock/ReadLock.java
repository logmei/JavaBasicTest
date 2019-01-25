package com.logmei.content.assorts.lock.readwritelock;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 11:14 2019/1/24
 * @ Description：读锁
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ReadLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()){
            //若此时有线程进行写操作，或者有写线程在等待并且偏向写锁的标识为true时，就会无法获得该锁，只能被挂起
            while (readWriteLock.getWritingWriter()>0 || (readWriteLock.getPreferWriter()&&readWriteLock.getWaitingWriter()>0)){
                readWriteLock.getMUTEX().wait();
            }
            //成功获得锁，并使readingReader的数量增加
            readWriteLock.incrementReadingReader();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()){
            //释放锁的过程就是使用当前reading的数量减一
            //将perferWriter设置为true,可以使得writer线程获得更多机会
            //通知唤醒与MUTEX关联monitor waitset中的线程
            readWriteLock.decrementReadingReader();
            readWriteLock.changePrefer(true);
            readWriteLock.getMUTEX().notifyAll();
        }

    }
}
