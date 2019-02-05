package com.logmei.content.assorts.designmodel.strategy;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 7:47 2019/2/3
 * @ Description：策略上下文
 * @ Modified By：
 * @Version: 1.0.0
 */
public  class   StrategyContext {

    private static IStrategy strategy;

    private static volatile StrategyContext strategyContext;

     StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }


    public static StrategyContext getInstance(IStrategy strategy){
        if (strategyContext == null){
            strategyContext = new StrategyContext(strategy);
            return strategyContext;
        }else {
            return strategyContext;
        }
    }
    public static void calc(int num1,int num2){
        strategy.calc(num1,num2);
    }


}
