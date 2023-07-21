package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] a = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(a);
        Arrays.sort(b);

        int left_a = 0;
        int right_a = n - 1;

        int left_b = 0;
        int right_b = n - 1;

        int result = 0;

        while (left_a <= right_a) {
            if (a[right_a] > b[right_b]) {
                result += 1;
                right_a--;
                right_b--;
            } else if (a[right_a] < b[right_b]) {
                result -= 1;
                left_a++;
                right_b--;
            } else {
                if (a[left_a] > b[left_b]) {
                    result += 1;
                    left_a++;
                    left_b++;
                } else {
                    if (b[right_b] > a[left_a]) result -= 1;
                    left_a++;
                    right_b--;
                }
            }
        }

        System.out.println(result);
    }

}