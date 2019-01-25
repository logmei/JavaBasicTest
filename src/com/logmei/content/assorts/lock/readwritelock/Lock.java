package com.logmei.content.assorts.lock.readwritelock;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 10:44 2019/1/24
 * @ Description：锁接口，基本操作，加锁、解锁
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface Lock {
    //获取显示锁，没有获得锁的线程将被阻塞
    void lock() throws InterruptedException;
    //释放获取锁
    void unlock();
}
