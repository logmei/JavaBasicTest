package com.logmei.content.assorts.annotation;

import java.lang.reflect.Method;

public class PersonAnn {
   public static void main(String[] args){
       //解析注解
       try {
           Class c = Class.forName("com.logmei.content.assorts.annotation.Child");
           //找到类上面是否有注解
           boolean b=c.isAnnotationPresent(Description.class);
           if(b){
               Description description=(Description)c.getAnnotation(Description.class);
               System.out.println(description.value());
           }
           /* 找到方法上的注解 */
           Method[] methods=c.getMethods();
           for (int i=0;i<methods.length;i++){
               boolean bm=methods[i].isAnnotationPresent(Description.class);
               if(bm){
                   Description description=(Description)methods[i].getAnnotation(Description.class);
                   System.out.println(description.value());
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
   }
}
