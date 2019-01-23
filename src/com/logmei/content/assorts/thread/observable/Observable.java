package com.logmei.content.assorts.thread.observable;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 9:53 2019/1/22
 * @ Description：被观察者接口
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface Observable {
    //生命周期的枚举类型
    enum Cycle{
        STARTED,RUNNING,DONE,ERROR
    }
    //获得当前任务生命周期状态
    Cycle getCycle();
    //定义启动线程的方法，主要作用是为了屏蔽Thread的其他方法
    void start();
    //定义线程的打断方法，作用与start方法一样，也是为了屏蔽Thread的其他方法
    void interrupt();
}
