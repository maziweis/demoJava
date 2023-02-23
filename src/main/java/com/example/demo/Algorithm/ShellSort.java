package com.example.demo.Algorithm;


import org.jetbrains.annotations.NotNull;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] a = {12, 33, 3, 23, 654, 233, 2, 65, 1};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void ShellSort(@NotNull int[] a) {
        int len = a.length;
        int gap;
        for (gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int cur = a[i];
                while (j - gap >= 0 && cur < a[j - gap]) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = cur;
            }
        }
    }

    public static void sort(int[] a) {
        int len = a.length;
        for (int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int cur = a[i];
                while (j - gap >= 0 && cur < a[j - gap]) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = cur;
            }
        }
    }

}
