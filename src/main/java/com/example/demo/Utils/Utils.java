package com.example.demo.Utils;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 数组深度复制
     *
     * @param strings
     * @return
     */
    public static String[][] copy(String[][] strings) {
        int x = strings.length;
        String[][] copyS = new String[x][x];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                copyS[i][j] = strings[i][j];
            }
        }
        return copyS;
    }

    /**
     * 两个数最大公约数为1
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean iszhishu(int a, int b) {
        int yushu = 0;
        while (a % b != 0) {
            yushu = a % b;
            a = b;
            b = yushu;
        }
        return b == 1;
    }

    /**
     * 字符串右侧补位
     *
     * @param s
     * @return
     */
    public static String stringRightPad(String s) {
        String str = s + "***";
        return str.substring(0, 4);
    }

    /**
     * 字符串反向排序
     *
     * @param s
     * @return
     */
    public static String stringReverse(String s) {
        char[] chr = s.toCharArray();
        String res = "";
        for (int i = chr.length - 1; i >= 0; i--) {
            if (chr[i] >= 'a' && chr[i] <= 'z' || chr[i] >= 'A' && chr[i] <= 'Z') {
                res += chr[i];
            } else {
                return s;
            }
        }
        return res;
    }

    public static List<Integer> copyList(List<Integer> a) {
        List<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            b.add(a.get(i));
        }
        return b;
    }
}
