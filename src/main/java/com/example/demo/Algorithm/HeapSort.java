package com.example.demo.Algorithm;

import com.example.demo.Utils;

import java.util.Arrays;

/**
 * 堆排序
 * 将无序数组构建成一个大顶堆
 * 将数组首尾互换，len-1，重新构建大顶堆
 * 重复上一步直到len=0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
        sort(a);
        System.out.println();
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjust(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            Utils.swap(a, 0, i);
            adjust(a, 0, i);
        }
    }

    public static void adjust(int[] a, int i, int len) {
        int tmp = a[i];
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && a[k] < a[k + 1]) k++;
            if (tmp < a[k]) {
                a[i] = a[k];
                i = k;
            } else break;
        }
        a[i] = tmp;
    }

    public static void sort1(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, a.length);
        }
        Utils.printA(a);
        for (int j = a.length - 1; j > 0; j--) {
            Utils.printA(a);
            Utils.swap(a, 0, j);
            adjustHeap(a, 0, j);
        }
    }


    public static void adjustHeap(int[] a, int i, int len) {
        Utils.printA(a);
        int tmp = a[i];
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && a[k] < a[k + 1]) {
                k++;
            }
            if (a[k] > tmp) {
                a[i] = a[k];
                i = k;
            } else break;
        }
        a[i] = tmp;
    }
}
