package com.example.demo.Algorithm;

import com.example.demo.Utils;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a, int begin, int end) {
        if (begin >= end)
            return;
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
        a[begin] = a[i];
        a[i] = tmp;
        sort(a, begin, i - 1);
        sort(a, i + 1, end);
    }

    public static void quickSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int tmp = a[begin];
        int i = begin;
        int j = end;
        while (i != j) {
            while (a[j] >= tmp && j > i)
                j--;
            while (a[i] <= tmp && j > i)
                i++;
            if (j > i) {
                Utils.swap(a, i, j);
            }
        }
        a[begin] = a[i];
        a[i] = tmp;
        quickSort(a, begin, i - 1);
        quickSort(a, i + 1, end);
    }

}
