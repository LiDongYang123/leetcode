package com.ldy.www.simple.day1;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author ldy
 * @Date 2020/3/20 10:12
 * @Version 1.0
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * Simple1:
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * Simple2:
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * Limit:
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 **/
public class SmallestNumber {

    @Test
    public void test(){
        int[] arr = {3,5,7,9,4,6,8,10,1,55,78,44};
        int k = 2;
        System.out.println(Arrays.toString(getLeastNumbers(arr,k)));
    }

    private int[] getLeastNumbers(int[] arr, int k){
        //冒泡排序
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<arr.length-i;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //选择排序（升序）
//        for (int i=0;i<arr.length-1;i++){
//            for (int j=i+1;j<arr.length;j++){
//                if (arr[i] > arr[j]){
//                    //交换
//                    int temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }
        int[] newArr = new int[k];
        for (int i=0;i<k;i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * 冒泡排序
     */
//    @Test
//    public void tempTest(){
//        int[] arr = {1,3,5,2,9,7};
//        for (int i=1;i<arr.length;i++){
//            for (int j=0;j<arr.length-i;j++){
//                if (arr[j] > arr[j+1]){
//                    int temp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//    }


    @Test
    public void testHeap(){
        int[] arr = {3,5,7,9,4,6,8,10,1,55,78,44};
        int k = 2;
        int[] res;
        if (k == 0) {
            res = new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        //res = new int[heap.size()];
        res = new int[k];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        System.out.println(Arrays.toString(res));
    }
}
