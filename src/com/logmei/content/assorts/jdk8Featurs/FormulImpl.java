package com.logmei.content.assorts.jdk8Featurs;

public class FormulImpl implements Formulable {

    @Override
    public double calculate(int a){
        return sqrt(a);
    }
    public static void main(String[] args){
        FormulImpl formul=new FormulImpl();
        System.out.println(formul.calculate(16));
    }
}
