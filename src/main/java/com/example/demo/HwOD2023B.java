package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

//https://blog.csdn.net/qq_34465338/article/details/130719693
public class HwOD2023B {

    public static void main(String[] args) {
        {
//                fenpinguo();
//                taiyangneng();
//                fentangguo();
//                paishuzi();
//                ziduanjiami();
//                huangjinbaoxiang();
//                xuanxiuke();
//                maidongxi();
//                paiweizhi();
//                ludengzhaoming();
//                han7();
//                fenban();
//                dapuke();
//                zhongshuP();
//                ipzhuanhuan();
//                stringDigest();
//                xiangyingbaowen();
//                shijiantuisong();
//                shuliemiaoshu();
//                zuixiaoshuzi();
        }
        while (true) {
//            shejibisai();
//            zhaozhongdian();
//            zifuchuanjiami();
//            zuiyuanzuji();
//            zuichangshunzi();
//            baowenchongpai();
//            shitanggongcan();
//            wuziqi();
//            dancijielong();
            bisaidafen();
        }
    }


    //int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    /**
     * 30 比赛
     */
    public static void bisaidafen() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        boolean wuxiao = false;
        if (lines[0] < 3 || lines[1] < 3) {
            wuxiao = true;
        }
        Map<Integer, List<Integer>> list = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < lines[0]; i++) {
            int[] linei = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < linei.length; j++) {
                if (linei[j] > 10 || linei[j] < 1) {
                    wuxiao = true;
                }
                if (i == 0) {
                    List<Integer> xuanshou = new ArrayList<>();
                    xuanshou.add(linei[j]);
                    list.put(j, xuanshou);
                } else {
                    list.get(j).add(linei[j]);
                }
            }
        }
        if (wuxiao) {
            System.out.println(-1);
            return;
        }
        //map排序
        Map<Integer, List<Integer>> sortMap = list.entrySet().stream().sorted((a, b) -> {
            int suma = a.getValue().stream().reduce(Integer::sum).get();
            int sumb = b.getValue().stream().reduce(Integer::sum).get();
            if (sumb == suma) {
                a.getValue().sort((x, y) -> y - x);
                b.getValue().sort((x, y) -> y - x);
                for (int i = 0; i < a.getValue().size(); i++) {
                    if (a.getValue().get(i) == b.getValue().get(i)) {
                        continue;
                    } else {
                        return b.getValue().get(i) - a.getValue().get(i);
                    }
                }
            }
            return sumb - suma;
        }).collect(Collectors.toMap(entry -> entry.getKey() + 1, entry -> entry.getValue(), (o, n) -> o, LinkedHashMap::new));
        StringBuilder res = new StringBuilder();
        sortMap.entrySet().stream().limit(3).forEach(entry -> {
            res.append(entry.getKey() + ",");
        });
        System.out.println(res.toString().substring(0, res.length() - 1));
        //以下是将Map的值排序之后只取key的前三个
//        List<String> collect = list.entrySet().stream().sorted((a, b) -> {
//            int suma = a.getValue().stream().reduce(Integer::sum).get();
//            int sumb = b.getValue().stream().reduce(Integer::sum).get();
//            if (sumb == suma) {
//                a.getValue().sort((x, y) -> y - x);
//                b.getValue().sort((x, y) -> y - x);
//                for (int i = 0; i < a.getValue().size(); i++) {
//                    if (a.getValue().get(i) == b.getValue().get(i)) {
//                        continue;
//                    } else {
//                        return b.getValue().get(i) - a.getValue().get(i);
//                    }
//                }
//            }
//            return sumb - suma;
//        }).map(a -> a.getKey() + 1 + "").limit(3).collect(Collectors.toList());
//        System.out.println(String.join(",", collect));
    }

    /**
     * 29 单词接龙
     */
    public static void dancijielong() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int num = sc.nextInt();
        sc.nextLine();
        List<String> lines = new ArrayList<String>();
        for (int j = 0; j < num; j++) {
            lines.add(sc.nextLine());
        }
        String first = lines.get(i);
        lines.remove(first);
        String next = first;
        String res = first;
        while (lines.size() > 0) {
            char c = next.charAt(next.length() - 1);
            List<String> ss = lines.stream().filter(s -> s.charAt(0) == c).sorted((a, b) -> {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return b.length() - a.length();
            }).limit(1).collect(Collectors.toList());
            if (ss.size() > 0) {
                next = ss.get(0);
                lines.remove(next);
                res += next;
            } else {
                break;
            }
        }
        System.out.println(res);
    }

    /**
     * 28 五子棋迷
     */
    public static void wuziqi() {
        Scanner sc = new Scanner(System.in);
        int yanse = sc.nextInt();
        sc.nextLine();
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        int juli = 0;
        int zuobiao = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] != 0) continue;
            int l = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (lines[j] == yanse) {
                    l++;
                } else break;
            }
            int r = 0;
            for (int j = i + 1; j < lines.length; j++) {
                if (lines[j] == yanse) {
                    r++;
                } else break;
            }
            int total = l + r;
            if (total >= 5) continue;
            if (total > max) {
                max = total;
                juli = Math.abs(i - lines.length / 2);
                zuobiao = i;
            } else if (total == max && juli > Math.abs(i - lines.length / 2)) {
                juli = Math.abs(i - lines.length / 2);
                zuobiao = i;
            }
        }
        System.out.println(zuobiao);
    }

    /**
     * 27 食堂供餐
     */
    public static void shitanggongcan() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        sc.nextLine();
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        double sum = Arrays.stream(lines).sum();
        int min = (int) Math.ceil((sum - start) / (n - 1));
        int shengyu = start - lines[0];
        for (int i = 1; i < n; i++) {
            shengyu = shengyu - lines[i] + min;
            if (shengyu < 0) {
                min++;
                i = 0;
                shengyu = start - lines[0];
            }
        }
        System.out.println(min);
    }

    /**
     * 26 报文重排序
     */
    public static void baowenchongpai() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] lines = sc.nextLine().split(" ");
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < lines.length; i++) {
            String str = lines[i];
            if (str.equals("")) {
                continue;
            }
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (Character.isDigit(c)) {
                    int no = Integer.parseInt(str.substring(j));
                    String content = str.substring(0, j);
                    map.put(no, content);
                    break;
                }
            }
        }
        List<String> collect = map.entrySet().stream().sorted((a, b) -> {
            return a.getKey() - b.getKey();
        }).map(entry -> entry.getValue()).collect(Collectors.toList());
        System.out.println(String.join(" ", collect));
    }

    /**
     * 25 最长的顺子
     */
    public static void zuichangshunzi() {
        Scanner sc = new Scanner(System.in);
        String[] shoupai = sc.nextLine().split("-");
        String[] paichi = sc.nextLine().split("-");
        List<String> list = new ArrayList<String>();
        List<Integer> jupai = new ArrayList<Integer>();
        Map<Integer, Integer> mingpai = new HashMap<Integer, Integer>();
        for (int i = 0; i < shoupai.length; i++) {
            Integer p = pukezhuanshuzi(shoupai[i] + "");
            mingpai.put(p, mingpai.getOrDefault(p, 0) + 1);
        }
        for (int i = 0; i < paichi.length; i++) {
            Integer p = pukezhuanshuzi(paichi[i] + "");
            mingpai.put(p, mingpai.getOrDefault(p, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mingpai.entrySet()) {
            if (entry.getValue() == 4) {
                jupai.add(entry.getKey());
            }
        }
        String temp = "";
        for (int i = 3; i < 15; i++) {
            if (!jupai.contains(i)) {
                temp += i + "-";
                if (i == 14) {
                    if (temp.length() > 0) {
                        temp = temp.substring(0, temp.length() - 1);
                        if (temp.split("-").length >= 5) {
                            list.add(temp);
                            temp = "";
                        }
                    }
                }
            } else {
                if (temp.length() > 0) {
                    temp = temp.substring(0, temp.length() - 1);
                    if (temp.split("-").length >= 5) {
                        list.add(temp);
                    }
                    temp = "";
                }
            }
        }
        if (list.size() == 0) {
            System.out.println("NO-CHAIN");
            return;
        }
        list.sort((a, b) -> {
            if (a.length() == b.length()) {
                return b.compareTo(a);
            }
            return b.length() - a.length();
        });
        String[] result = list.get(0).split("-");
        for (int j = 0; j < result.length; j++) {
            result[j] = shuzizhuanpuke(Integer.parseInt(result[j]));
        }
        System.out.println(String.join("-", result));

    }

    public static Integer pukezhuanshuzi(String num) {
        switch (num) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            case "2":
                return 15;
            case "小王":
                return 16;
            case "大王":
                return 17;
            default:
                return Integer.valueOf(num);
        }
    }

    /**
     * 24 最远足迹
     */
    public static void zuiyuanzuji() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = 0;
        String zuobiao = "(0,0)";
        int l = 0, r = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                l = i + 1;
            } else if (str.charAt(i) == ')') {
                r = i;
            }
            if (r > 0) {
                String[] s = str.substring(l, r).split(",");
                if (s[0].indexOf("0") == 0 || s[1].indexOf("0") == 0) {
                    l = r = 0;
                    continue;
                }
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                if (x < 1 || x > 999 || y < 1 || y > 999) {
                    l = r = 0;
                    continue;
                }
                if (x * x + y * y > max) {
                    max = x * x + y * y;
                    zuobiao = "(" + x + "," + y + ")";
                }
                l = r = 0;
            }
        }
        System.out.println(zuobiao);
    }

    /**
     * 23 	字符串加密
     */
    public static void zifuchuanjiami() {
        Scanner sc = new Scanner(System.in);
        String zimu = "abcdefghijklmnopqrstuvwxyz";
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String strMi = "";
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int p = pianyi(j);
                int cI = zimu.indexOf(c);
                strMi += zimu.charAt((p + cI) % 26);
            }
            System.out.println(strMi);
        }

    }

    public static int pianyi(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            default:
                return pianyi(i - 1) + pianyi(i - 2) + pianyi(i - 3);
        }
    }

    /**
     * 22 找终点
     */
    public static void zhaozhongdian() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < lines.length / 2; j++) {
            int temp = 1;
            for (int i = j; i < lines.length; ) {
                if (i > lines.length - 1) break;
                if (i == lines.length - 1) {
                    min = Math.min(min, temp);
                    break;
                }
                i += lines[i];
                temp++;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    /**
     * 21 统计射击比赛成绩
     */
    public static void shejibisai() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] ren = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] fen = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> huizong = new HashMap<Integer, Integer>();
        for (int i = 0; i < ren.length; i++) {
            List<Integer> temp = map.get(ren[i]);
            if (temp == null) {
                temp = new ArrayList<Integer>();
            }
            temp.add(fen[i]);
            map.put(ren[i], temp);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() < 3) continue;
            value.sort((a, b) -> b.compareTo(a));
            value = value.stream().limit(3).collect(Collectors.toList());
            int sum = value.stream().mapToInt(Integer::intValue).sum();
            huizong.put(entry.getKey(), sum);
        }
        List<String> collect = huizong.entrySet().stream().sorted((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        }).map(s -> s.getKey().toString()).collect(Collectors.toList());
        System.out.println(String.join(",", collect));
    }

    /**
     * 20 数组组成的最小数字
     */
    public static void zuixiaoshuzi() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = Arrays.stream(lines).boxed().collect(Collectors.toList());
        list.sort((a, b) -> a.compareTo(b));
        list = list.stream().limit(3).collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        shuzizuheBackTrack(list, new ArrayList<String>(), res);
        Integer nu = res.stream().min((a, b) -> a.compareTo(b)).get();
        System.out.println(nu);
    }

    public static void shuzizuheBackTrack(List<Integer> list, List<String> temp, List<Integer> res) {
        if (temp.size() == list.size()) {
            String str = String.join("", temp);
            res.add(Integer.parseInt(str));
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (temp.contains(list.get(i).toString())) continue;
                temp.add(list.get(i).toString());
                shuzizuheBackTrack(list, temp, res);
                temp.remove(list.get(i).toString());
            }
        }
    }

    /**
     * 19 数列描述
     */
    public static void shuliemiaoshu() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] a = new String[num + 1];
        a[0] = "1";
        for (int i = 1; i < num + 1; i++) {
            a[i] = chulishulie(a[i - 1]);
        }
        System.out.println(a[num]);
    }

    public static String chulishulie(String num) {
        char c = num.charAt(num.length() - 1);
        String str = "";
        int n = 1;
        for (int i = num.length() - 2; i >= 0; i--) {
            if (num.charAt(i) != c) {
                str = n + "" + c + str;
                c = num.charAt(i);
                n = 1;
            } else {
                n++;
            }
        }
        if (n != 0) {
            str = n + "" + c + str;
        }
        return str;
    }

    /**
     * 18 事件推送
     */
    public static void shijiantuisong() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] linesA = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] linesB = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = lines[2];
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < linesA.length; i++) {
            for (int j = 0; j < linesB.length; j++) {
                if (linesA[i] <= linesB[j] && r >= linesB[j] - linesA[i]) {
                    list.add(linesA[i] + " " + linesB[j]);
                    break;
                }
            }
        }
        list.forEach(System.out::println);
    }

    /**
     * 17 响应报文时间
     */
    public static void xiangyingbaowen() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] lines = new String[num];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            lines[i] = sc.nextLine();
            int no = Integer.parseInt(lines[i].split(" ")[0]);
            int time = Integer.parseInt(lines[i].split(" ")[1]);
            if (time >= 128) {
                String code = Integer.toString(time, 2);
                int mant = Integer.parseInt(code.substring(4), 2);
                int exp = Integer.parseInt(code.substring(1, 4), 2);
                int mrt = (mant | 0X10) << (exp + 3);
                min = Math.min(min, mrt + no);
            } else {
                min = Math.min(min, time + no);
            }
        }
        System.out.println(min);
    }

    /**
     * 16 字符串摘要
     */
    public static void stringDigest() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase().trim();
        List<Character> chars = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                chars.add(c);
            }
        }
        int temp = 0;
        List<String> res = new ArrayList<String>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = chars.size() - 1; i >= 0; i--) {
            if (i != chars.size() - 1) {
                if (!chars.get(i).equals(chars.get(i + 1))) {
                    if (temp > 1) {
                        res.add(chars.get(i + 1) + "" + temp);
                    } else {
                        res.add(chars.get(i + 1) + "" + map.getOrDefault(chars.get(i + 1), 0));
                    }
                    map.put(chars.get(i + 1), temp);
                    temp = 1;
                } else {
                    temp++;
                }
                if (i == 0) {
                    if (temp > 1) {
                        res.add(chars.get(i) + "" + temp);
                    } else {
                        res.add(chars.get(i) + "" + map.getOrDefault(chars.get(i), 0));
                    }
                }
            } else {
                temp++;
                if (i == 0) {
                    res.add(chars.get(i) + "0");
                }
            }

        }
        res.sort((a, b) -> {
            if (a.substring(1).equals(b.substring(1))) {
                return a.substring(0, 1).compareTo(b.substring(0, 1));
            }
            return Integer.parseInt(b.substring(1)) - Integer.parseInt(a.substring(1));
        });
        res.forEach(a -> System.out.print(a));
        System.out.println();
    }


    /**
     * 15 IPv4地址转换成整数
     */
    public static void ipzhuanhuan() {
        Scanner sc = new Scanner(System.in);
        long[] lines = Arrays.stream(sc.nextLine().split("#")).mapToLong(Integer::parseInt).toArray();
        boolean invalid = true;
        long count = 0;
        if (lines.length < 4) {
            invalid = false;
        } else {
            for (int i = 0; i < lines.length; i++) {
                if (i == 0 && (lines[i] < 1 || lines[i] > 128)) {
                    invalid = false;
                    break;
                }
                if (lines[i] < 0 || lines[i] > 255) {
                    invalid = false;
                    break;
                }
                count += lines[i] << 8 * (3 - i);
            }
        }
        if (invalid) {
            System.out.println(count);
        } else {
            System.out.println("invalid IP");
        }
    }

    /**
     * 14 补种未成活胡杨
     * 补种的树一定是连续的才会最多，分为 最开始种k颗、最后种k颗，或者中间种k颗三种情况
     */
    public static void zhongshuP() {
        Scanner sc = new Scanner(System.in);
        int all = sc.nextInt();
        int sishu = sc.nextInt();
        sc.nextLine();
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int buzhong = sc.nextInt(); // 补种的数的数量
        int max = 0;
        for (int i = buzhong - 1; i < sishu; i++) {//i是死树数组中，补种的最后一棵树的下标
            if (i == buzhong - 1) {  //最开始补种buzhong棵树
                max = Math.max(max, lines[i + 1] - 1);
            } else if (i == sishu - 1) { //最后补种buzhong棵树
                max = Math.max(max, all - lines[sishu - buzhong - 1]);
            } else { //中间补种buzhong棵树，从下标buzhong开始
                max = Math.max(max, lines[i + 1] - 1 - lines[i - buzhong]);
            }
        }
        System.out.println(max);
    }

    public static void zhongshu() {
        Scanner sc = new Scanner(System.in);
        int all = sc.nextInt();
        int sishu = sc.nextInt();
        sc.nextLine();
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int buzhong = sc.nextInt();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < sishu - buzhong; i++) {
            List<Integer> list1 = new ArrayList<Integer>();
            for (int j = i; j < sishu - buzhong + i; j++) {
                list1.add(lines[j]);
            }
            list.add(list1);
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list3 = list.get(i);
            int[] shu = new int[all];
            for (int j = 0; j < all; j++) {
                if (list3.contains(j + 1)) {
                    shu[j] = 0;
                } else {
                    shu[j] = 1;
                }
            }
            max = Math.max(max, qiulianxu(shu));
        }
        System.out.println(max);
    }

    public static int qiulianxu(int[] a) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        max = Math.max(max, temp);
        return max;
    }

    /**
     * 13 斗地主之顺子
     */
    public static void dapuke() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<Integer>();
        for (String s : lines) {
            if (s.equals("2"))
                continue;
            else if (s.equals("J"))
                list.add(11);
            else if (s.equals("Q"))
                list.add(12);
            else if (s.equals("K"))
                list.add(13);
            else if (s.equals("A"))
                list.add(14);
            else list.add(Integer.valueOf(s));
        }
        list.sort((a, b) -> a.compareTo(b));
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(list.get(0));
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<List<String>> res1 = new ArrayList<List<String>>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - 1 == temp.get(temp.size() - 1)) {
                temp.add(list.get(i));
            } else {
                if (temp.size() >= 5) {
                    res.add(new ArrayList<Integer>(temp));
                }
                list.removeAll(temp);
                if (list.size() == 0) {
                    break;
                }
                i = 0;
                temp.clear();
                temp.add(list.get(0));
            }
        }
        if (res.size() == 0) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(shuzizhuanpuke(res.get(i).get(j)) + " ");
            }
            System.out.println();
        }
    }

    public static String shuzizhuanpuke(Integer num) {
        switch (num) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            default:
                return String.valueOf(num);
        }
    }

    /**
     * 12 分班
     */
    public static void fenban() {
        Scanner sc = new Scanner(System.in);
        try {
            String[] lines = sc.nextLine().split(" ");
            boolean biao = true;
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> list1 = new ArrayList<Integer>();
            for (int i = lines.length - 1; i >= 0; i--) {
                String temp = lines[i];
                if (i == lines.length - 1) {
                    list.add(Integer.parseInt(temp.split("/")[0]));
                    biao = temp.split("/")[1].equals("Y") ? true : false;
                    continue;
                }
                if (biao) {
                    list.add(Integer.parseInt(temp.split("/")[0]));
                } else {
                    list1.add(Integer.parseInt(temp.split("/")[0]));
                }
                biao = temp.contains("Y") ? biao : !biao;
            }
            list.sort((a, b) -> a.compareTo(b));
            list1.sort((a, b) -> a.compareTo(b));
            if (list.get(0) < list1.get(0)) {
                list.stream().forEach(s -> System.out.print(s + " "));
                System.out.println();
                list1.stream().forEach(s -> System.out.print(s + " "));
            } else {
                list1.stream().forEach(s -> System.out.print(s + " "));
                System.out.println();
                list.stream().forEach(s -> System.out.print(s + " "));
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    /**
     * 11 	喊7的次数重排
     */
    public static void han7() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(lines).sum();
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i < lines.length + 1; i++) {
            map.put(i, 0);
        }
        for (int i = 1; i < 201; i++) {
            if (i % 7 == 0 || String.valueOf(i).contains("7")) {
                res++;
                map.put(i % lines.length, map.getOrDefault(i % lines.length, 0) + 1);
                if (res == sum) {
                    break;
                }
            }
        }
        map.entrySet().stream().forEach(entry -> System.out.print(entry.getValue() + " "));
        System.out.println();
    }

    /**
     * 10 路灯照明问题
     */
    public static void ludengzhaoming() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for (int i = 0; i < lines.length - 1; i++) {
            int temp = lines[i] + lines[i + 1] - 100;
            if (temp < 0) {
                res -= temp;
            }
        }
        System.out.println(res);
    }

    public static void paiweizhi() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        int count = 0;
        boolean isFirst = true;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == 1) {
                if (isFirst && count > 1) {
                    isFirst = false;
                    res += count / 2;
                }
                if (count > 2) {
                    res += (count - 1) / 2;
                }
                count = 0;
            } else {
                count++;
            }
        }
        if (count > 1) {
            res += count / 2;
        }
        System.out.println(res);
    }

    /**
     * 8 最大花费金额  三数之和
     */
    public static void maidongxi() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).sorted().toArray();
        int money = sc.nextInt();
        int max = 0;
        if (lines.length < 3) {
            System.out.println(-1);
            return;
        }
        if (lines.length == 3) {
            int all = Arrays.stream(lines).sum();
            System.out.println(all > money ? -1 : all);
            return;
        }
        for (int i = 0; i < lines.length - 2; i++) {
            if (i > 0 && lines[i] == lines[i - 1]) continue;
            int l = i + 1;
            int r = lines.length - 1;
            while (l < r) {
                int sum = lines[i] + lines[l] + lines[r] - money;
                if (sum == 0) {
                    System.out.println(money);
                    return;
                }
                if (sum < 0) {
                    l++;
                    max = Math.max(max, sum + money);
                } else {
                    r--;
                }
            }
        }
        System.out.println(max == 0 ? -1 : max);
    }

    /**
     * 7 选修课
     */
    public static void xuanxiuke() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(";");
        String[] lines2 = sc.nextLine().split(";");
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        for (int i = 0; i < lines.length; i++) {
            map.put(lines[i].split(",")[0], lines[i].split(",")[1]);
        }
        for (int i = 0; i < lines2.length; i++) {
            String[] ke2 = lines2[i].split(",");
            if (map.get(ke2[0]) != null) {
                int fen = Integer.parseInt(map.get(ke2[0])) + Integer.parseInt(ke2[1]);
                map1.put(ke2[0], fen);
            }
        }

        if (map1.size() == 0) {
            System.out.println("NULL");
            return;
        }
        List<Map.Entry<String, Integer>> list = map1.entrySet().stream().sorted((a, b) -> {
            if (a.getKey().substring(0, 5).equals(b.getKey().substring(0, 5))) {
                if (b.getValue() == a.getValue()) {
                    return a.getKey().substring(5, 8).compareTo(b.getKey().substring(5, 8));
                }
                return b.getValue() - a.getValue();
            }
            return a.getKey().substring(0, 5).compareTo(b.getKey().substring(0, 5));
        }).collect(Collectors.toList());
        Map<String, String> map2 = new HashMap<String, String>();
        for (int i = 0; i < list.size(); i++) {
            String temp = map2.get(list.get(i).getKey().substring(0, 5));
            if (temp != null) {
                temp += ";" + list.get(i).getKey();
            } else {
                temp = list.get(i).getKey();
            }
            map2.put(list.get(i).getKey().substring(0, 5).toString(), temp);
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     * 6 阿里巴巴找黄金宝箱(I)
     */
    public static void huangjinbaoxiang() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(lines).sum();
        int l = 0;
        for (int i = 0; i < lines.length; i++) {
            if (2 * l == sum - lines[i]) {
                System.out.println(i);
                return;
            } else {
                l += lines[i];
            }
        }
        System.out.println(-1);
    }

    /**
     * 5 敏感字段加密
     */
    public static void ziduanjiami() {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] lines = str.split("_");
        List<String> list = new ArrayList<String>();
        for (int i = index; i < lines.length; i++) {
            if (!lines[i].equals("")) {
                list.add(lines[i]);
            }
        }
        String temp = "";
        boolean yinhao = false;
        for (int i = str.indexOf(list.get(0)); i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                if (yinhao) {
                    temp += str.charAt(i);
                } else {
                    break;
                }
            } else {
                temp += str.charAt(i);
                if (str.charAt(i) == '\"') {
                    yinhao = !yinhao;
                }
            }
        }
        System.out.println(str.replace(temp, "******"));
    }

    /**
     * 4 组成最大数
     */
    public static void paishuzi() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(",");
        for (int i = 0; i < lines.length - 1; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                String temp = "";
                if ((lines[i] + lines[j]).compareTo(lines[j] + lines[i]) < 0) {
                    temp = lines[j];
                    lines[j] = lines[i];
                    lines[i] = temp;
                }
            }
        }
        System.out.println(Arrays.stream(lines).collect(Collectors.joining()));
    }


    /**
     * 3 	分糖果
     */
    public static void fentangguo() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        fentangguoBianLi(list, num, 0);
        System.out.println(list.stream().min((a, b) -> a - b).get());
    }

    public static void fentangguoBianLi(List<Integer> list, int n, int m) {
        if (n == 1) {
            list.add(m);
        } else {
            if ((n & 1) != 0) {
                fentangguoBianLi(list, n + 1, ++m);
                fentangguoBianLi(list, n - 1, ++m);
            } else {
                fentangguoBianLi(list, n / 2, ++m);
            }
        }
    }

    /**
     * 2 太阳能板最大面积
     */
    public static void taiyangneng() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int lI = 0;
        int rI = lines.length - 1;
        int l = lines[lI];
        int r = lines[rI];
        int res = 0;
        while (lI < rI) {
            int temp = Math.min(l, r) * (rI - lI);
            res = Math.max(res, temp);
            if (lines[lI] < lines[rI]) {
                l = lines[++lI];
            } else {
                r = lines[--rI];
            }
        }
        System.out.println(res);
    }

    /**
     * 1 分苹果
     */
    public static void fenpinguo() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] zhongliang = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for (int i = 0; i < zhongliang.length; i++) {
            res ^= zhongliang[i];
        }
        if (res == 0) {
            System.out.println(Arrays.stream(zhongliang).min().getAsInt());
        } else {
            System.out.println(-1);
        }

    }
}
