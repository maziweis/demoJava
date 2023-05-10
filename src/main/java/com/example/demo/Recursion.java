package com.example.demo;

public class Recursion {
    public static void main(String[] args) {
//        reverseStr("123456789");
//        System.out.println(fact(new int[]{1, 55, 748, 67, 4}, 4));
//        System.out.println(zuidagongyueshu(9, 21));
        move(3, "A", "B", "C");
    }

    /**
     * 汉诺塔问题
     *
     * @param dish 盘子个数(也表示名称)
     * @param from 初始塔座
     * @param temp 中介塔座
     * @param to   目标塔座
     */
    public static void move(int dish, String from, String temp, String to) {
        if (dish == 1) {//圆盘只有一个的时候 将其从a移动到c
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
        } else {
            move(dish - 1, from, to, temp);//a为初始塔座，b为目标塔座，c为中介塔座
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标" + to);//把a上面的最下面的一个盘子移到c上面
            move(dish - 1, temp, from, to);//b为初始塔座，c为目标塔座，a为中介塔座
        }
    }

    public static void printReverse(String n) {
        helper(0, n.toCharArray());
    }

    public static void helper(int n, char[] s) {
        if (n >= s.length) return;
        helper(n + 1, s);
        System.out.println(s[n]);
    }

    public static int zuidagongyueshu(int x, int y) {
        if (x % y == 0) return y;
        else {
            return zuidagongyueshu(y, x % y);
        }
    }


    /**
     * 求斐波那契数列之和
     *
     * @param x
     * @return
     */
    public static int sumFib(int x) {
        if (x == 1) return 1;
        if (x == 2) return 2;
        return sumFib(x - 1) + fib(x);
    }

    /**
     * 求斐波那契数列第几位
     *
     * @param x
     * @return
     */
    public static int fib(int x) {
        if (x == 1 || x == 2) return 1;
        else {
            return fib(x - 1) + fib(x - 2);
        }
    }

    /**
     * 数组求和
     *
     * @param numbers
     * @param start
     * @return
     */
    public static int fact(int[] numbers, int start) {
        if (numbers.length - 1 == start) return numbers[start];
        else {
            return numbers[start] + fact(numbers, start + 1);
        }
    }

    /**
     * 求x的阶乘
     *
     * @param x
     * @return
     */
    public static int fact(int x) {
        if (x == 1) return 1;
        else {
            return x * fact(x - 1);
        }
    }

    /**
     * 反转字符串
     *
     * @param s
     */
    public static void reverseStr(String s) {
        helper(s.toCharArray(), 0);
    }

    public static void helper(char[] chars, int index) {
        if (index == chars.length) return;
        helper(chars, index + 1);
        System.out.println(chars[index]);
    }
}
