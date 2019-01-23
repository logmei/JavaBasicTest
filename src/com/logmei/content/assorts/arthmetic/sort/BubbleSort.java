package com.logmei.content.assorts.arthmetic.sort;

import com.logmei.content.tools.interfaces.ISort;

import java.util.Arrays;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 17:06 2019/1/18
 * @ Description：冒泡排序
 * @ Modified By：
 * @Version: 1.0.0
 */
public class BubbleSort implements ISort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        print(arr);
        bubbleSort(arr);

        return arr;
    }

    private void bubbleSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            //没次排序最后面的数为最大
            boolean flag = true;//若没有交换位置说明已经排好序 退出
            for (int j = 0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if(flag == true)break;
        }
    }
}
