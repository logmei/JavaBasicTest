package com.logmei.content.assorts.designmodel.singleton;

/**
 * 懒汉模式+同步方法 懒加载
 * 构造函数私有化
 * 当使用该类的时候创建实例
 *
 * 多线程下不安全，需要增加同步锁
 */
public class SingletonSynchronized {
    private static SingletonSynchronized singleton;
    static {
        System.out.println("SingletonSynchronized++++++static+++++++++++++++++++++++");
    }
    private SingletonSynchronized() {
    }

    //多线程访问  会出现共享数据多次访问的问题   所以加synchronized
    public synchronized static final SingletonSynchronized getInstance(){

            if(singleton == null){
                System.out.println("SingletonSynchronized.getInstance++++++++");
                singleton = new SingletonSynchronized();

            }
            return singleton;

    }
}
