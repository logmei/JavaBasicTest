package com.logmei.content.assorts.designmodel.observer;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 17:26 2019/1/22
 * @ Description：观察者
 *定义了update方法，当 被观察者调用notifyObserver方法时，观察者的update方法会被回调
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface Observer {
    void update(String message);
}
