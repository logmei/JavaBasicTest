package com.logmei.content.assorts.lock.readwritelock;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 15:37 2019/1/24
 * @ Description：writelock
 * @ Modified By：
 * @Version: 1.0.0
 */
public class WriteLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;

    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()){
            try{
                //首先使等待获取写入锁的数字加一
                readWriteLock.incrementWaitingWriter();
                while (readWriteLock.getReadingReader()>0 || readWriteLock.getWritingWriter()>0){
                    readWriteLock.getMUTEX().wait();
                }
            }finally {
                //成功获取到写入锁，使等待获取写入锁的计数器减一
                readWriteLock.decrementWaitingWriter();
            }
            //将正在写入的线程数量加一
            readWriteLock.incrementWritingWriter();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()){
            //减少正在写入锁的线程计数器
            readWriteLock.decrementWritingWriter();
            //将偏好状态修改为false,可以使得读锁被最快速的获得
            readWriteLock.changePrefer(false);
            //通知唤醒其他的MUTEXT monitor waitset中的线程
            readWriteLock.getMUTEX().notifyAll();
        }

    }
}
