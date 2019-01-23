package com.logmei.content.test;

public class childClassTest extends ClassTest {
    public int id;
    private int privateId;
    public static String staticS;
    public static final String staticFinalS="sdfsdf";

    public childClassTest(String ss, int id, int privateId) {
        super(ss);
        this.id = id;
        this.privateId = privateId;
    }


}
