package com.example.demo.Algorithm;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] a = {2, 3, 2, 5, 6, 1, 4, 6, 3, 74, 400, 92, 502};
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void radixSort(int[] a) {
        int max = 0;
        for (int i : a) {
            if (i > max) max = i;
        }
        int digit = 0;
        while (max > 0) {
            max /= 10;
            digit++;
        }
        int mod = 10, dev = 1;
        for (int i = 0; i < digit; i++, dev *= 10, mod *= 10) {
            int[][] buckets = new int[mod * 2][0];//考虑负数的情况，[0-9]放负数,[10-19]放正数
            for (int j : a) {
                int index = ((j % mod) / dev) + mod;
                buckets[index] = BucketSort.arrAppend(buckets[index], j);
            }
            int pos = 0;
            for (int[] bucket : buckets) {
                for (int k : bucket) {
                    a[pos++] = k;
                }
            }
        }
    }
}
