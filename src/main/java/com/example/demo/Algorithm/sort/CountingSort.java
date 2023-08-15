package com.example.demo.Algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 * 创建一个原数组a最大值-最小值+1大小的数组b，默认赋值0
 * 遍历原数组a，将b中相应位置的值+1，最后得到按a顺序排的元素个数的新数组
 * 遍历b，将a中元素替换为b的下标值+a的最小值
 */
public class CountingSort {


    public static void main(String[] args) {

        int[] a = {2, 3, 2, 5, 6, 1, 4, 6, 3, 7, 4, 9};
        sort1(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort1(int[] a) {
        int bias, min = 0, max = 0;
        for (int i : a) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i : a) {
            bucket[i + bias]++;
        }
        int index = 0;
        while (index < a.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i]-- != 0) {
                    a[index] = i + min;
                    index++;
                    i--;
                }
            }
        }
    }


    /**
     * 排序
     */
    public static void sort(int[] a) {
        int bias, min = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
            if (a[i] < min)
                min = a[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i : a) {
            bucket[i + bias]++;
        }
        int index = 0, i = 0;
        while (index < a.length) {
            if (bucket[i]-- != 0) {
                a[index] = i - bias;
                index++;
            } else i++;
        }
    }
}
