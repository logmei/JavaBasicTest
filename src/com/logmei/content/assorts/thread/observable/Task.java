package com.logmei.content.assorts.thread.observable;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 10:06 2019/1/22
 * @ Description：函数接口 任务
 * @ Modified By：
 * @Version: 1.0.0
 */
@FunctionalInterface
public interface Task<T> {
    //任务执行接口，该接口允许有返回值
    T call();
}
