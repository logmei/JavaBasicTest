package com.logmei.content.assorts.designmodel.singleton;

/**
 * 恶汉模式
 * final 不能被继承
 * 确保类只生成一个实例，以解决全局使用的类频繁的创建和删除
 *
 * 将类的构造函数私有化
 * 在类中定义好实例
 * 加载类时已经实例化好
 * 通过public方法调用
 */
public final class Singleton1 {
    private static final Singleton1 singleTon = new Singleton1();
    static {
        System.out.println("Singleton1++++++static+++++++++++++++++++++++");
    }

    private Singleton1() {
        System.out.println("Singleton1+++++++++++++++++++++++++++++");
    }

    public static Singleton1 getInstance(){
        return singleTon;
    }
}
