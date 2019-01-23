package com.logmei.content.test;

public class ClassTest {
    public int id;
    private int privateId;
    //定义时候初始化或构造函数时候初始化
    public final String ss;
    //static变量属于类不属于对象
    public static String staticS;
    //static 和 final定义的变量，由于不能被构造函数初始化，所以定义时需要初始化
    public static final String staticFinalS="staticFinal-value";


    public ClassTest(String ss) {
        this.ss = ss;
    }



    public ClassTest(){
        ss="final-value";
    }

    protected static String ss(){
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public String getSs() {
        return ss;
    }

    public static String getStaticS() {
        return staticS;
    }

    public static void setStaticS(String staticS) {
        ClassTest.staticS = staticS;
    }

    public static String getStaticFinalS() {
        return staticFinalS;
    }
}
