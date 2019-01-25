package com.logmei.content.tools.interfaces;

import java.util.Arrays;

public interface ISort {
    int[] sort(int[] sourceArray);

    default void print(int[] arr){
        System.out.println(this.getClass().getName());
        Arrays.stream(arr).forEach(i->System.out.print(""+i+","));
        System.out.println();
    }
    default void swap(int[] arr,int i,int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
}
