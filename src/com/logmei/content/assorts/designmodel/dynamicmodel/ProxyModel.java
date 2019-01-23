package com.logmei.content.assorts.designmodel.dynamicmodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//掉用InvocationHandler实现代理类
public class ProxyModel implements InvocationHandler {
   private Object target;

   //绑定业务对象返回代理对象
   public Object bind(Object target){
       this.target = target;

//       通过反射机制，创建一个代理类实例对象并返回，用户进行方法掉用时使用
//       创建代理对象时需要传递业务对象的加载器、业务对象接口、handler实现
       return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
   }

    @Override
//    包装调用方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       Object result = null;
       System.out.println("------------处理前----------------");
//调用真正的业务处理方法
       result = method.invoke(target,args);
       System.out.println("--------------处理后-----------------");
        return result;
    }
}
