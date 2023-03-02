package com.example.demo.Algorithm;

import java.util.Arrays;

/**
 * 桶排序
 * 将原数组的元素按照大小放在不同的桶里面
 * 将桶的元素排序
 * 将桶的元素添加到一个新数组，返回新数组
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] a = {2, 3, 2, 5, 6, 1, 4, 6, 3, 7, 4, 9};
        a = sort(a, 5);
        System.out.println(Arrays.toString(a));
    }

    public static int[] sort(int[] a, int bucketSize) {
        int min = 0, max = 0;
        for (int i : a) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];
        int index;
        for (int i : a) {
            index = (i - min) / bucketSize;
            buckets[index] = arrAppend(buckets[index], i);
        }
        int[] arr = new int[0];
        for (int[] bucket : buckets) {
            if (bucket.length > 0) {
                InsertionSort.sort(bucket);
                arr = arrAppend(arr, bucket);
            }
        }
        return arr;
    }

    /**
     * @param a
     * @param bucketSize 桶的尺寸
     * @return
     */
    public static int[] bucketSort(int[] a, int bucketSize) {
        int min = 0, max = 0;
        for (int i : a) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        int bucketCount = (max - min) / bucketSize + 1; //桶的个数
        int[][] buckets = new int[bucketCount][0];
        int index;
        for (int i : a) {
            index = (i - min) / bucketSize;
            buckets[index] = arrAppend(buckets[index], i);
        }
        int[] arr = new int[0];
        for (int[] bucket : buckets) {
            if (bucket.length == 0)
                continue;
            InsertionSort.sort(bucket);
            arr = arrAppend(arr, bucket);
        }
        return arr;
    }

    public static int[] arrAppend(int[] a, int v) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = v;
        return a;
    }

    public static int[] arrAppend(int[] a, int[] v) {
        int len = a.length;
        a = Arrays.copyOf(a, len + v.length);
        System.arraycopy(v, 0, a, len, v.length);
        return a;
    }
}
