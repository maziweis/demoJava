package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HwOD {

    public static void main(String[] args) {
        Object res = caizimi("conection", "connection,today");
        System.out.println(res);
    }

    public static String caizimi(String mimian, String midi) {
        String[] mimianA = mimian.split(",");
        String[] midiA = midi.split(",");
        List<String> resL = new ArrayList<>();
        for (int i = 0; i < mimianA.length; i++) {
            String mm = mimianA[i];
            boolean isFound = false;
            for (int j = 0; j < midiA.length; j++) {
                String md = midiA[j];
                if (change(mm, md) || distString(mm, md)) {
                    isFound = true;
                    resL.add(md);
                }
            }
            if (!isFound) {
                resL.add("not found");
            }
        }
        return String.join(",", resL);
    }

    /**
     * 字符串重排序后是否相等
     *
     * @param question
     * @param answer
     * @return
     */
    public static boolean change(String question, String answer) {
        String[] q = question.split("");
        Arrays.sort(q);
        String[] a = answer.split("");
        Arrays.sort(a);
        if (Arrays.equals(q, a)) {
            return true;
        }
        return false;
    }

    /**
     * 字符串去重后是否相等
     *
     * @param question
     * @param answer
     * @return
     */
    public static boolean distString(String question, String answer) {
        List<Character> listQ = new ArrayList<>();
        List<Character> listA = new ArrayList<>();
        for (int i = 0; i < question.toCharArray().length; i++) {
            if (!listQ.contains(question.charAt(i))) {
                listQ.add(question.charAt(i));
            }
        }
        for (int i = 0; i < answer.toCharArray().length; i++) {
            if (!listA.contains(answer.charAt(i))) {
                listA.add(answer.charAt(i));
            }
        }
        if (listQ.equals(listA)) {
            return true;
        }
        return false;
    }
}
