package com.logmei.content.assorts.designmodel.structural;

/**
 * 主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式
 */
public class Flyweight {
    public static void main(String[] args) {
        // 这里Integer类中实现了享元模式，==比较来判断两者地址值是否相同。重用已有对象。String类中加入有相同对象时，不创建新的对象而是使用常量池中的数据。
        String a ="a";
        String b = new String("a");
        Flyweight f = new Flyweight();
        System.out.println("a的值"+a);//String重写了toString方法
        System.out.println("b的值"+b);
        System.out.println("f的值："+f);//没有重写toString方法，打印的是地址
        System.out.println("a.hashcode="+a.hashCode());
        System.out.println("b.hashcode="+b.hashCode());
        System.out.println("a与b的地址是否相等："+(a == b));
        System.out.println("a与b的内容是否相等："+(a .equals(b) ));
    }
}
