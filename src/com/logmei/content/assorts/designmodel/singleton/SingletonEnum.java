package com.logmei.content.assorts.designmodel.singleton;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 18:20 2019/1/19
 * @ Description：枚举方式
 * 枚举不允许继承，是线程安全的，只能实例化一次
 * @ Modified By：
 * @Version: 1.0.0
 */
public enum SingletonEnum {
    INSTANCE;
    SingletonEnum(){

    }
    public static SingletonEnum getInstance(){
        return INSTANCE;
    }
}
