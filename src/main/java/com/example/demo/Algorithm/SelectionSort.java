package com.example.demo.Algorithm;

import com.example.demo.Utils;

import java.util.Arrays;

/**
 * 选择排序 找到最小的和第i个互换，i= 0，1，2...
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {12, 33, 3, 23, 654, 233, 2, 65};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        int len = a.length;
        int minIndex;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            Utils.swap(a, minIndex, i);
        }
    }
}
