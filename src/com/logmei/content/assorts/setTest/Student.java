package com.logmei.content.assorts.setTest;

import java.util.Objects;

public class Student {
    private int card;
    private String name;
    private int sex;

    public int getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Student(int card, String name, int sex) {
        this.card = card;
        this.name = name;
        this.sex = sex;
    }
 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return card == student.card &&
                name == student.name &&
                sex == student.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, name, sex);
    }
}
