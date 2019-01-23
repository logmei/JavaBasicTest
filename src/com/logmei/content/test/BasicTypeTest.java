package com.logmei.content.test;

public class BasicTypeTest {

    public static void main(String[] args){
        String a="hello2";
        final String b="hello";
        String c="hello";
        System.out.println("a=b+2:"+(a==(b+2)));
    }
}
