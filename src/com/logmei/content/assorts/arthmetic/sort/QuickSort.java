package com.logmei.content.assorts.arthmetic.sort;

import com.logmei.content.tools.interfaces.ISort;

import java.util.Arrays;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 10:59 2019/1/18
 * @ Description：快速排序
 * @ Modified By：
 * @Version: 1.0.0
 */
public class QuickSort implements ISort {

    /**
     * description:排序入口
     * @return
     */

    public int[] sort(int[] sourceArray){
        //进行拷贝
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        print(arr);
        return quickSort(arr,0,sourceArray.length);
    }

    //递归排序
    public int[] quickSort(int[] arr , int left , int right){
        if(left < right){
            //排序并返回新的基点位置
            int basciPoint = parttion(arr ,left , right);
            quickSort(arr,left,basciPoint-1);//去除掉基点位置
            quickSort(arr,basciPoint+1,right);
        }
       return arr;
    }

    //基准数排序并返回当前基准数的位置
    public int parttion(int[] arr, int left, int right){
        //基点位置 设置为最左边
        int basciPoint = left;
        int index = left + 1;
        //从最左边开始查找比基点小的数，找到交换，再继续
        for (int i = index;i < right ; i++){
            //若该位置的值小于基点值 (找到一个index++)
            if(arr[basciPoint] > arr[i] ){
                swap(arr,index,i) ;//交换位置
                index++;
            }
        }
        //查找完毕后将基点与index-1交换位置（index-1 保证左边都是比基数小的）
        swap(arr,basciPoint,index-1);
        return index-1;//返回基点位置
    }


}
