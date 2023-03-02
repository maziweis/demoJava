package com.example.demo.Algorithm;

import java.util.Arrays;

/**
 * 插入排序
 * 当前值从第二个开始，和前一个比较，如果当前值小于前一个值，则将前一个值赋给当前坐标，pre--；一直循环
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {12, 33, 3, 23, 654, 233, 2, 65};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        int len = a.length;
        int preIndex, cur;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            cur = a[i];
            while (preIndex >= 0 && cur < a[preIndex]) {
                a[preIndex + 1] = a[preIndex];
                preIndex--;
            }
            a[preIndex + 1] = cur;
        }
    }
}
