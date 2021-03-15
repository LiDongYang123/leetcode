package com.jl.simple;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author ldy
 * @Date 2020/3/20 14:22
 * @Version 1.0
 *
 * 模仿
 **/
public class MyQuickSort {

    @Test
    public void test(){
        int[] arr = {72,6,57,88};
        System.out.println(Arrays.toString(getLeastNumbers(arr,3)));
    }


    /**
     *
     * @param arr   待排序的数组
     * @param k     待查询的数量
     * @return
     */
    public int[] getLeastNumbers(int[] arr,int k){

        if (k == 0){
            return new int[0];
        }else if (k >= arr.length){
            return arr;
        }

        //划分数组
        partitionArray(arr,k,0,arr.length-1);

        int[] newArr = new int[k];
        for (int i=0;i<k;i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public void partitionArray(int[] arr,int k,int start,int end){
        //数组中标记的前半部分的数，如果m=k，则完成迭代
        int m = partition(arr,start,end);
        if (m == k){
            return ;
        }else if (m > k){
            //m>k,说明k全部包含在m中，则在m中继续迭代
            partitionArray(arr,m-k,start,m-1);
        }else {
            //m<k,说明k包含m，且有k-m个数在标记的右侧
            partitionArray(arr,k-m,m+1,end);
        }
    }

    int partition(int[] arr,int start,int end){
        //设置循环的局部变量
        int i = start;
        int j = end;
        //临时标记(随意选择，本次选左界限)
        int temp = arr[start];

        while (true){

            while (arr[++i] <= temp){
                if (i == end){
                    break;
                }
            }

            while (arr[--j] >= temp){
                if (j == start){
                    break;
                }
            }

            if (i >= j){
                break;
            }

            swap(arr,i,j);
        }

        //最后一次交换：把最初的标志位start与最高位end交换
        swap(arr,start,j);

        return j + 1;
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
