package com.example.demo;

public class Utils {
    public static void swap(int[] list,int a, int b){
        Integer temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
