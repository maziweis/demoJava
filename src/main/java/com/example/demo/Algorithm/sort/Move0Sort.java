package com.example.demo.Algorithm.sort;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,31,12]
 * 输出: [1,31,12,0,0]
 */
public class Move0Sort {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] a) {
        int slow = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[slow] = a[i];
                slow++;
            }
        }
        for (int i = slow; i < a.length; i++) {
            a[i] = 0;
        }
    }
}
