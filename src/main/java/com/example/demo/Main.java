package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String yuan = sc.nextLine();
        String mubiao = sc.nextLine();

        List<String> mubiaoList = new ArrayList<>();
        String temp = "";
        //是否在中括号里面
        boolean isKuohao = false;
        for (int i = 0; i < mubiao.length(); i++) {
            char c = mubiao.charAt(i);
            if ((c == '[' || c == ']')) {
                if (temp != "") {
                    mubiaoList.add(temp);
                    temp = "";
                }
                isKuohao = !isKuohao;
            } else if (isKuohao) {
                //在中括号里面的则进行拼接（模糊查询）
                temp += c;
            } else {
                //不在中括号里面的需要精确匹配
                mubiaoList.add(String.valueOf(c));
            }
        }

        int res = -1;
        for (int i = 0; i < yuan.length(); i++) {

            String s = String.valueOf(yuan.charAt(i));
            //是否能够匹配
            boolean isMatch = true;
            if (s.equals(mubiaoList.get(0))) {
                //第一个字符对应上了
                //源字符串的索引
                int index = i + 1;
                //遍历目标字符串
                for (int j = 1; j < mubiaoList.size(); j++) {
                    String str = mubiaoList.get(j);
                    if (index < yuan.length() && str.contains(String.valueOf(yuan.charAt(index)))) {
                        //源字符串索引没有越界，且字符符合目标中的字符
                        index++;
                    } else {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    res = i;
                    break;
                }
            }

        }

        System.out.println(res);
    }

}