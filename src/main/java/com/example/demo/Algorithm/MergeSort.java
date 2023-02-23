package com.example.demo.Algorithm;

import java.util.Arrays;

/**
 * 归并排序
 * 把长度为n的数组分为n/2的俩个数组
 * 依次递归到最后数组长度为1，排序两个数组
 * 归并上面数组，再次排序，直到合并
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {12, 33, 3, 23, 654, 233, 2, 65, 1};
        a = mergeSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] mergeSort(int[] a) {
        int len = a.length;
        if (len < 2)
            return a;
        int mid = len / 2;
        int[] l = Arrays.copyOfRange(a, 0, mid);
        int[] r = Arrays.copyOfRange(a, mid, len);
        return sort(mergeSort(l), mergeSort(r));
    }

    public static int[] sort(int[] l, int[] r) {
        int[] res = new int[l.length + r.length];
        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
            if (i >= l.length)
                res[index] = r[j++];
            else if (j >= r.length)
                res[index] = l[i++];
            else if (l[i] > r[j])
                res[index] = r[j++];
            else res[index] = l[i++];
        }
        return res;
    }

}
