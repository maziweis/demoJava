package com.example.demo.Algorithm;

import java.util.Scanner;

public class Main {
    static int[] pizza;
    // 缓存
    static long[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        pizza = new int[n];
        for (int i = 0; i < n; i++) {
            pizza[i] = sc.nextInt();
        }

        // 缓存
        cache = new long[n][n];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            //ans = Math.max(ans, recursive(check(i - 1), check(i + 1)) + pizza[i]);
        }
        int[] all = new int[3 * n];
        System.arraycopy(pizza, 0, all, 0, n);
        System.arraycopy(pizza, 0, all, n, n);
        System.arraycopy(pizza, 0, all, 2 * n, n);
        for (int i = n; i < 2 * n - 1; i++) {
            ans = Math.max(ans, compare(all, i - 1, i + 1, n) + all[i]);
        }
        System.out.println(ans);
    }

    public static int compare(int[] all, int l, int r, int n) {
        if (all[l] > all[r]) {
            l--;
        } else {
            r++;
        }
        if (r - l == n) {
            return all[l];
        } else {
            return Math.max(compare(all, l - 1, r, n) + all[l], compare(all, l, r + 1, n) + all[r]);
        }
    }

    public static int check(int i) {
        if (i < 0) {
            return pizza.length - 1;
        } else if (i >= pizza.length) {
            return 0;
        } else {
            return i;
        }
    }

    public static long recursive(int l, int r) {
        if (pizza[l] > pizza[r]) {
            l = check(l - 1);
        } else {
            r = check(r + 1);
        }

        // 缓存优化，如果对应缺口状态的披萨铁盘结果已经算过了，则无需再次重复递归
        if (cache[l][r] > 0) {
            return cache[l][r];
        }

        if (l == r) {
            // 缓存对应缺口状态下，吃货可得的最大披萨大小
            cache[l][r] = pizza[l];
        } else {
            // 缓存对应缺口状态下，吃货可得的最大披萨大小
            cache[l][r] =
                    Math.max(recursive(check(l - 1), r) + pizza[l], recursive(l, check(r + 1)) + pizza[r]);
        }

        return cache[l][r];
    }

}