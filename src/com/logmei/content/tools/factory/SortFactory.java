package com.logmei.content.tools.factory;

import com.logmei.content.assorts.arthmetic.sort.BubbleSort;
import com.logmei.content.assorts.arthmetic.sort.InsertSort;
import com.logmei.content.assorts.arthmetic.sort.QuickSort;
import com.logmei.content.tools.interfaces.ISort;
import com.logmei.content.tools.enums.SortTypeEnum;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 14:08 2019/1/18
 * @ Description：工程接口实现 单例模式
 * @ Modified By：
 * @Version: 1.0.0
 */

public class SortFactory implements ISortFactory{
    private SortFactory(){}
    @Override
    public ISort creteSort(SortTypeEnum sortTypeEnum) {
        if(SortTypeEnum.QUICK.getCode() == sortTypeEnum.getCode()) return new QuickSort();
        if(SortTypeEnum.INSERT.getCode() == sortTypeEnum.getCode()) return new InsertSort();
        if(SortTypeEnum.BUBBLE.getCode() == sortTypeEnum.getCode()) return new BubbleSort();
        return null;
    }

    //防止类加载时进行初始化   和多线程实例化多次的问题
    private static class inner{
        private static final SortFactory sortFactory = new SortFactory();
    }
    public static SortFactory getInstance(){
        return inner.sortFactory;
    }
}
