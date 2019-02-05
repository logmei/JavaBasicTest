package com.logmei.content.assorts.designmodel.strategy;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 7:44 2019/2/3
 * @ Description：加
 * @ Modified By：
 * @Version: 1.0.0
 */
public class AddStrategy implements IStrategy {
    @Override
    public void calc(int num1, int num2) {
        System.out.format("%d+%d=%d/n",num1,num2,(num1+num2));
    }
}
