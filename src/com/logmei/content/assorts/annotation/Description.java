package com.logmei.content.assorts.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited//运行子类继承
@Documented//生成javadoc时包含注解
//类前面用@interface定义，代表不是接口是注解
public @interface Description {
    //可以为空
    //成员变量若为一个的话必须为value，使用时可以省略=
    String value();
    //成员变量
  /*  String name();
    String autor();
    //默认值 default指定
    int age() default 18;*/
}
