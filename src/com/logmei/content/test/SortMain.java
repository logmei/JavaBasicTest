package com.logmei.content.test;

import com.logmei.content.tools.enums.SortTypeEnum;
import com.logmei.content.tools.factory.SortFactory;
import com.logmei.content.tools.interfaces.ISort;

import java.sql.Time;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 14:31 2019/1/18
 * @ Description：排序测试主函数
 * @ Modified By：
 * @Version: 1.0.0
 */
public class SortMain {
    static SortFactory  sortFactory = SortFactory.getInstance();
    public static void main(String[] args){
        printResult(SortTypeEnum.BUBBLE);
        printResult(SortTypeEnum.QUICK);
        printResult(SortTypeEnum.INSERT);


    }

    private static void printResult(SortTypeEnum sortTypeEnum){
        ISort sortinterface = sortFactory.creteSort(sortTypeEnum);
        int[] arr = {4,2,7,5,3,8,1,9,10,33,12,23,435,554,654,34,45,678,345,453,456,76,46};
        long  startT = System.currentTimeMillis();
       // System.out.println("starttime:"+startT);
        int[] newarr = sortinterface.sort(arr);
       // System.out.println();
        long endT = System.currentTimeMillis();
        //System.out.println("endtime:"+endT);
        System.out.format("%s used Time :%d\n",sortTypeEnum.getDescription(),diffTime(startT,endT));
        Arrays.stream(newarr).forEach(i->System.out.print(i+","));
        System.out.println();
        System.out.println("---------------------------");
        arr = null;
        newarr = null;
    }

    private static  long diffTime(long startTime,long endTime){
        long diff = endTime-startTime;
        return diff;
    }

}
