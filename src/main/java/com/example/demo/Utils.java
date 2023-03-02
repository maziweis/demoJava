package com.example.demo;

public class Utils {
    public static void swap(int[] list, int a, int b) {
        Integer temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public static void printA(int[] a) {
        int index = 0;
        int len = arrayHeight(a);
        for (int i = 0; i < a.length; i++) {
            if ((i == index * 2 + 1) || i == 0) {
                index = i;
                System.out.println();
                printlT(len);
                len--;
            }
            System.out.print(printlT(len) + a[i]);
        }
    }

    public static String printlT(int i) {
        String n = "\t";
        for (int j = 0; j < i; j++) {
            n += "\t";
        }
        return n;
    }

    public static int arrayHeight(int[] a) {
        int len = 0;
        for (int i = a.length; i > 0; i = i / 2) {
            len++;
        }
        return len;
    }

    /**
     * 数字金字塔
     */
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("\t");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j + "\t");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }


}
