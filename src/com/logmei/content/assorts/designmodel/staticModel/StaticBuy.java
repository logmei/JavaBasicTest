package com.logmei.content.assorts.designmodel.staticModel;

public class StaticBuy implements IStaticBuy{
    @Override
    public void buyThings() {
        System.out.println("my buy things!");

    }

    public static void main(String[] args){
        StaticBuy staticBuy = new StaticBuy();
        StaticProxy proxy = new StaticProxy(staticBuy);
        proxy.buyThings();
    }
}
