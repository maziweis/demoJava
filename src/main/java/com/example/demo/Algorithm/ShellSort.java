package com.example.demo.Algorithm;


import org.jetbrains.annotations.NotNull;

/**
 * 希尔排序
 * 第一次将数组拆成n/2个，将n/2->n的值和0->n/2的值进行比较互换
 * 第二次将数组拆成n/2/2个，将n/2/2的值和0比较互换，然后比较后一位，类推
 * 第n次，直到n/2...=0
 * 举例 8位 则是4 2 1 三次，9位 也是4 2 1 三次 只不过最后一位n第一次需要比较两次和n/2与0
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] a = {12, 33, 3, 23, 654, 233, 2, 65, 1};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(@NotNull int[] a) {
        int len = a.length;
        int gap;
        for (gap = len / 2; gap > 0; gap = gap / 2) {
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
