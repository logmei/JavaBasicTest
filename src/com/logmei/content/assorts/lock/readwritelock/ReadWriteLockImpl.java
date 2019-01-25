package com.logmei.content.assorts.lock.readwritelock;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 11:24 2019/1/24
 * @ Description：提供读写锁方法
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ReadWriteLockImpl implements ReadWriteLock {
    //定义对象锁
    private final Object MUTEX = new Object();
    //当前有多少线程正在写入
    private int writingWriter = 0;
    //当前有多少线程正在等待写入
    private int waitingWriter = 0;
    //当前有多少线程正在读
    private int readingReader = 0;
    //read和write的偏好设置
    private boolean preferWriter;
    //默认情况下perferWriter为true
    public ReadWriteLockImpl(){
        this(true);
    }
    //构造方法传入preferWriter
    public ReadWriteLockImpl(boolean preferWriter){
        this.preferWriter = preferWriter;
    }
    public Lock readLock(){
        return new ReadLock(this);
    }
    public Lock writeLock(){
        return new WriteLock(this);
    }
    void incrementWritingWriter(){
        this.writingWriter++;
    }
    void decrementWritingWriter(){
        this.writingWriter--;
    }
    void incrementWaitingWriter(){
        this.waitingWriter++;
    }
    void decrementWaitingWriter(){
        this.waitingWriter--;
    }
    void incrementReadingReader(){
        this.readingReader++;
    }
    void decrementReadingReader(){
        this.readingReader--;
    }


    public int getWritingWriter(){
        return this.writingWriter;
    }
    public int getWaitingWriter(){
        return this.waitingWriter;
    }
    public int getReadingReader(){
        return this.readingReader;
    }
    Object getMUTEX(){
        return this.MUTEX;
    }
    boolean getPreferWriter(){
        return this.preferWriter;
    }
    void changePrefer(boolean preferWriter){
        this.preferWriter = preferWriter;
    }
}
