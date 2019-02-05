package com.logmei.content.assorts.designmodel.strategy;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 7:46 2019/2/3
 * @ Description：减
 * @ Modified By：
 * @Version: 1.0.0
 */
public class SubtractStrategy implements IStrategy {
    @Override
    public void calc(int num1, int num2) {
        System.out.format("%d-%d=%d",num1,num2,(num1-num2));
    }
}
