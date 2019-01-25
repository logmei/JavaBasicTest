package com.logmei.content.assorts.lock.readwritelock;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 11:00 2019/1/24
 * @ Description：创建读锁和写锁，并且提供查询功能
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface ReadWriteLock {
    //创建read锁
    Lock readLock();
    //创建write锁
    Lock writeLock();

    //获取当前有多少线程正在执行写操作
    int getWritingWriter();
    //获取当前有多少线程正在等待获取写入锁
    int getWaitingWriter();
    //获取当前有多少线程正在等待获取reader锁
    int getReadingReader();

    static ReadWriteLock readWriteLock(){
        return new ReadWriteLockImpl();
    }

    static ReadWriteLock readWriteLock(boolean preferWriter){
        return new ReadWriteLockImpl(preferWriter);
    }

}
