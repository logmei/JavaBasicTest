package com.logmei.content.assorts.thread.executorService;

@FunctionalInterface
public interface ThreadFactory {
    //创建线程
    Thread createThread(Runnable runnable);
}
