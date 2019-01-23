package com.logmei.content.assorts.designmodel.observer;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 17:23 2019/1/22
 * @ Description：被观察者接口
 * 声明了添加，删除，通知观察者方法
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface Observable {
    //注册观察者
    void registedObservable(Observer observer);
    //删除观察者
    void removeObservable(Observer observer);
    //通知观察者
    void notifyObservable();
}
