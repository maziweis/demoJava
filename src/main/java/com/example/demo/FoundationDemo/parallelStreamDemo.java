package com.example.demo.FoundationDemo;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class parallelStreamDemo {

    public static void main(String[] args) {
        test();
    }


    static void test() {
        long t0 = System.nanoTime();
        //初始化一个范围100万整数流,求能被2整除的数字，toArray()是终点方法
        int a[] = IntStream.range(0, 1_000_000).filter(p -> p % 2 == 0).toArray();
        long t1 = System.nanoTime();

        int[] b = IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2 == 0).toArray();
        long t2 = System.nanoTime();
        System.out.printf("serial: %.3fs, parallel %.3fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
    }}
