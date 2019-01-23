package com.logmei.content.assorts.designmodel.singleton;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 16:49 2019/1/19
 * @ Description：Double-Check 懒汉模式+同步方法+双重校验
 *
 * 出现空指针错误
 * 根据JVM运行时指令重排序和Happens-Before规则，若先实例化还没有初始化connection时,会报空指针
 * 解决办法为：private volatile static SingletonVolatileDoubleCheck singleton = null;
 *
 * @ Modified By：
 * @Version: 1.0.0
 */
public final class SingletonVolatileDoubleCheck {
    private static SingletonVolatileDoubleCheck singleton = null;

    public static Connection connection;
    public static Socket socket;
    private SingletonVolatileDoubleCheck(){
        Conn();
        socket = new Socket();

    }
    public static SingletonVolatileDoubleCheck getInstance(){
        //避免每次都需要进入同步代码块，提高效率
        if(null == singleton){
            synchronized (SingletonVolatileDoubleCheck.class){
                if(null == singleton){
                    singleton = new SingletonVolatileDoubleCheck();
                }

            }
        }
        return singleton;
    }

    private void Conn(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/";
        String username = "root";
        String password = "root";
        //加载驱动
        try {
            //将driver实例注册进DriverManager 与DriverManager.registerDriver(new com.mysql.jdbc.Driver())作用是完全等价的
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
