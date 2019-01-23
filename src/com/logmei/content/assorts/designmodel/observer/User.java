package com.logmei.content.assorts.designmodel.observer;

import java.util.Objects;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 19:44 2019/1/22
 * @ Description：用户
 * @ Modified By：
 * @Version: 1.0.0
 */
public class User implements Observer{
    public String userCode;
    public String userName;
    public Integer sex;
    public String email;
    public String message;

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }
    public void read(){
        System.out.println(userName + "收到推送消息："+ message);
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName,email);
    }

    @Override
    public String toString() {
        return "User{" +
                "userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }

    public User(String userName) {
        this.userName = userName;
    }
}
