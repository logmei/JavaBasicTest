package com.logmei.content.assorts.thread.executorService;

@FunctionalInterface
//拒绝策略
public interface DenyPolicy {
    void reject(Runnable runnable,ThreadPool threadPool);

    class DiscardDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {

        }
    }
}
