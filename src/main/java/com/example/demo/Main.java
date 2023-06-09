package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        int c = ints[0];
        int b = ints[1];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            //将数字转化为16进制并用0填满8位数
            String To16 = String.format("%08x", ints[i + 2]);
            //四个字节的和
            int count = 0;
            for (int j = 0; j < 7; j += 2) {
                count += Integer.valueOf(To16.substring(j, j + 2));
            }

            int mo = count % b;
            if (mo < c) {
                map.put(mo, map.getOrDefault(mo, 0) + 1);
            }
        }

        int max = 0;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }

        System.out.println(max);
    }

}