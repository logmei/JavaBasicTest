package com.logmei.content.assorts.designmodel.strategy;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 7:49 2019/2/3
 * @ Description：测试
 * @ Modified By：
 * @Version: 1.0.0
 */
public class TestMain {
    public static void main(String[] args){
        IStrategy strategy = new AddStrategy();
        StrategyContext strategyContext = new StrategyContext(strategy);
        strategyContext.calc(2,5);
    }


}
