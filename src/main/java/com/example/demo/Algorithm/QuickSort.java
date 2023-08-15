package com.example.demo.Algorithm;

import com.example.demo.Utils.Utils;

import java.util.Arrays;

/**
 * 快速排序
 * 判断begin（从0开始）>= end(len-1) return
 * 选择第一个数作为基准p，先从右边end往左找小于p的数下标为j，在从左begin往右找大于p的下标为i，swap(a,i,j)
 * 循环上一步，直到i=j
 * 此时数组分为begin->i-1 和 i+1->end 循环2-3两步（拆成左右两个，递归）
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a, int begin, int end) {
        if (begin >= end) return;
        int tmp = a[begin];
        int i = begin;
        int j = end;
        while (i < j) {
            while (i < j && tmp <= a[j])
                j--;
            while (i < j && tmp >= a[i])
                i++;
            if (i < j)
                Utils.swap(a, i, j);
        }
        Utils.swap(a, begin, i);
        sort(a, begin, i - 1);
        sort(a, i + 1, end);
    }

}
