package com.logmei.content.tools.factory;

import com.logmei.content.tools.interfaces.ISort;
import com.logmei.content.tools.enums.SortTypeEnum;

/**
 * 工厂接口
 */
@FunctionalInterface
public interface ISortFactory {
     ISort creteSort(SortTypeEnum sortTypeEnum);
}
