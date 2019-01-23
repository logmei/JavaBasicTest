package com.logmei.content.assorts.designmodel.observer;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 20:22 2019/1/22
 * @ Description：公众号发布消息
 * @ Modified By：
 * @Version: 1.0.0
 */
public class TestMain {
    public static void main(String[] args){
        WechatServer wechatServer = new WechatServer();

        Observer user1 = new User("张三");
        Observer user2 = new User("李四");
        Observer user3 = new User("王五");

        wechatServer.registedObservable(user1);
        wechatServer.registedObservable(user2);
        wechatServer.registedObservable(user3);

        wechatServer.setInfomation("发送广播");
        System.out.println("---------------------------------");
        wechatServer.removeObservable(user1);
        wechatServer.setInfomation("再次发送广播");
    }
}
