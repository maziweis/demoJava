package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int count = sc.nextInt();
        final String[] arr = line.split(" ");
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i >= count) {
                String key = arr[i - count];
                map.put(key, map.get(key) - 1);
            }
            Integer integer = map.get(arr[i]);
            if (integer == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], integer + 1);
            }
            integer = map.get(arr[i]);
            if (integer > max) {
                max = integer;
            }
        }
        System.out.println(max);
    }
}