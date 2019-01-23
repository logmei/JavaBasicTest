package com.logmei.content.assorts.jdk8Featurs;

public interface Formulable {

    double calculate(int a);

    /**
     * 扩展方法，子类直接使用
     * @param a
     * @return
     */
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
