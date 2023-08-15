package com.example.demo.Algorithm;

import com.example.demo.Utils.Utils;

/**
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 232, 454, 65, 32, 54, 76};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    Utils.swap(a, j, j + 1);
                }
            }
        }
    }
}
