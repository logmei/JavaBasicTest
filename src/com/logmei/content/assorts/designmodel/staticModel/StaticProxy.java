package com.logmei.content.assorts.designmodel.staticModel;

public class StaticProxy implements IStaticBuy {
    private StaticBuy buy;

    public StaticProxy(StaticBuy buy) {
        this.buy = buy;
    }

    @Override
    public void buyThings() {
        System.out.println("------------before buy --------------");
        buy.buyThings();
        System.out.println("--------------after buy--------------");
    }
}
