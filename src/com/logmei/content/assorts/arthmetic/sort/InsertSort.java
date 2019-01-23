package com.logmei.content.assorts.arthmetic.sort;

import com.logmei.content.tools.interfaces.ISort;

import java.util.Arrays;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 13:27 2019/1/18
 * @ Description：插入排序
 * @ Modified By：
 * @Version: 1.0.0
 */
public class InsertSort implements ISort {

    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        print(arr);
        return insertSort(arr);
    }

    //进行插入排序  从左边开始
    public int[] insertSort(int[] arr ){
        for(int i = 1 ;i<arr.length;i++){
            parttion(arr,i);
        }
        return arr;

    }

    //一个基准点操作
    public void parttion(int[] arr,int index){
        int basicPoint = index;
        for (int i = index-1;i >=0 ;i--){
          if(arr[i] < arr[basicPoint]){
              swap(arr,i,index);
              basicPoint = i;
          }
        }
    }

}
