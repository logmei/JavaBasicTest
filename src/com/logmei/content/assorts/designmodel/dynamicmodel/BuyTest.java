package com.logmei.content.assorts.designmodel.dynamicmodel;

public class BuyTest {

    public static void main(String[] args){
        BuyImpl buyImpl = new BuyImpl();
        ProxyModel buy = new ProxyModel();
        IBuy iBuy = (IBuy) buy.bind(buyImpl);
        iBuy.buyThings();

    }
}
