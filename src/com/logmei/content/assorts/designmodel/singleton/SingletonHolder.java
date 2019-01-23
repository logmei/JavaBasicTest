package com.logmei.content.assorts.designmodel.singleton;

/**
 * holder模式
 * 静态内部类仅在调用时加载
 *
 * 线程安全
 */
public class SingletonHolder {
    private SingletonHolder() {
        System.out.println("construct+++++++++++++");
    }

    static {
        System.out.println("singleton3++++++++++++++++++++++++=");
    }
    static class inner{
        static {
            System.out.println("singleton3  inner ++++++++++++++++++++++++=");
        }

        private static final SingletonHolder singleton = new SingletonHolder();
    }

    public static final SingletonHolder getInstance(){
        return inner.singleton;
    }




}
