package com.logmei.content.assorts.designmodel.observer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 17:33 2019/1/22
 * @ Description：微信公众号服务，订阅后不定时发送消息，取消不收到消息
 * @ Modified By：
 * @Version: 1.0.0
 */
public class WechatServer implements Observable {
    private ConcurrentHashMap<Observer,Object> userMap;
    private String message;

    public WechatServer() {
        this.userMap = new ConcurrentHashMap<>();
    }

    @Override
    public void registedObservable(Observer observer) {
        userMap.put(observer,"");

    }

    @Override
    public void removeObservable(Observer observer) {
        userMap.remove(observer,"");

    }

    @Override
    public void notifyObservable() {
        for(Observer observer : userMap.keySet()){
            observer.update(message);
        }
    }

    public void setInfomation(String s){
        this.message = s;
        System.out.println("微信服务更新消息:"+s);
        notifyObservable();
    }
}
