package com.example.demo;


import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HwOD {

    public static void main(String[] args) {
        {
//        caizimi("conection", "connection,today");
//        Object res = muban(5, 3, new int[]{5, 5, 5, 5, 5});
//        Object res = commonCode("private_void_method", "public_void_method ");
//        getDanRuKou();
//        Object res = reverseStrings("yM eman si boB.");
//        getStringSiteChar();
//        Object res = newspaper2anonymousLetter("ab bcd ef", "cd ef");
//        huobizhuanhuan();
//        wanmeizouwei();
//        zidongbaoguang();
//        Object res = logfenshu1();
//        arrayCenter();
//        zuiduanArraywuma();
//        shangpindazhe();
//        reverseJuZhen();
//        while (1 == 1) {
//            bigVersion();
//        }
//        centerNode();
//        duilietiaozheng();
//        jieMiString();
//        touLanDaSai();
//            renWuZhiXingShiChang();
//        zhaoShuZi();
//        zhaJinHua();
        }
        {
//        baixiangzi();
//        yuanGongRecord();
//        zifuchaunzichuan();
//            tiquzichuan();
//            cheliangyanse();
//            yuangongdaka();
//            qiche();
//        jimushuzijuli();
//        gongzuoanpai();
//            xuanzejiudian();
//            xuexiaoweizhi1();
//            xunzhaomima();
//            xunzhaoyaoshi();
//            chongdianzhan();
//            chongdianshebei();
        }
        while (1 == 1) {
//            zhishitupu();
//            jingtaidaimasaomiao();
            guoyuanshifei();


        }


    }

    /**
     * 42 不爱施肥的小布
     */
    public static void guoyuanshifei() {
        Scanner sc = new Scanner(System.in);
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] len = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (num[0] > num[1]) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(len);
        int l = len[0];
        int r = len[num[0] - 1];
        while (r > l) {
            int mid = (l + r) / 2;
            int ans = 0;
            for (int i = 0; i < num[0]; i++) {
                int temp = (len[i] + mid - 1) / mid;
                ans += temp;
            }
            if (ans <= num[1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    /**
     * 41 静态代码扫描服务
     */
    public static void jingtaidaimasaomiao() {
        Scanner sc = new Scanner(System.in);
        int huancun = sc.nextInt();
        sc.nextLine();
        int[] biaoshi = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] daxiao = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> nonum = new HashMap<Integer, Integer>();
        Map<Integer, Integer> nosize = new HashMap<Integer, Integer>();
        for (int i = 0; i < biaoshi.length; i++) {
            nonum.put(biaoshi[i], nonum.getOrDefault(biaoshi[i], 0) + 1);
            nosize.put(biaoshi[i], daxiao[i]);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : nonum.entrySet()) {
            int huancunI = nosize.get(entry.getKey()) + huancun;
            int saomiaoI = nosize.get(entry.getKey()) * entry.getValue();
            res += Math.min(huancunI, saomiaoI);
        }
        System.out.println(res);
    }

    /**
     * 40 知识图谱新词挖掘1
     */
    public static void zhishitupu() {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        String word = sc.nextLine();
        String newWord = stringSort(word);
        int res = 0;
        for (int i = 0; i < content.length() - newWord.length() + 1; i++) {
            String temp = stringSort(content.substring(i, newWord.length() + i));
            if (temp.equals(newWord)) {
                res++;
            }
        }
        System.out.println(res);
        System.out.println();
    }

    public static String stringSort(String str) {
        String[] chars = str.split("");
        Arrays.sort(chars);
        return String.join("", chars);
    }

    /**
     * 39 查找充电设备组合  回溯
     */
    public static void chongdianshebei() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] gl = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = sc.nextInt();
        chongdianMax = 0;
        backTrackChongDian(gl, 0, max, 0);
        System.out.println(chongdianMax);
    }

    static int chongdianMax = 0;

    public static void backTrackChongDian(int[] gl, int index, int max, int sum) {
        if (index >= gl.length || sum >= max) {
            if (sum == max) {
                chongdianMax = max;
            } else {
                chongdianMax = Math.max(chongdianMax, sum - gl[index - 1]);
            }
        } else {
            for (int i = index; i < gl.length; i++) {
                sum += gl[i];
                backTrackChongDian(gl, i + 1, max, sum);
                sum -= gl[i];
            }
        }
    }

    /**
     * 39 查找充电设备组合
     */
    public static void chongdianzhan() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] cdz = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = sc.nextInt();
        int[][] result = new int[num + 1][max + 1];
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (j < cdz[i - 1]) {
                    result[i][j] = result[i - 1][j];
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - cdz[i - 1]] + cdz[i - 1]);
                }
            }
        }
        System.out.println(result[num][max]);
        System.out.println();
    }

    /**
     * 38 寻找关键钥匙
     */
    public static void xunzhaoyaoshi() {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine().toLowerCase();
        String[] lines = sc.nextLine().toLowerCase().split(" ");
        String lKey = String.join("", Arrays.stream(key.split("")).sorted().collect(Collectors.toList()));
        for (int i = 0; i < lines.length; i++) {
            String temp = lines[i];
            String ch = "";
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) >= 'a' && temp.charAt(j) <= 'z') {
                    ch += temp.charAt(j);
                }
            }
            ch = String.join("", Arrays.stream(ch.split("")).sorted().collect(Collectors.toList()));
            if (lKey.equals(ch)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }

    /**
     * 37 寻找密码
     */
    public static void xunzhaomima() {
        Scanner sc = new Scanner(System.in);
        List<String> lines = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        lines.sort((a, b) -> a.compareTo(b));
        boolean res = false;
        for (int i = lines.size() - 1; i >= 0; i--) {
            String s = lines.get(i);
            for (int j = s.length() - 1; j >= 0; j--) {
                if (lines.indexOf(s.substring(0, j)) == -1) {
                    break;
                }
                if (j == 1)
                    res = true;
            }
            if (res) {
                System.out.println(s);
                break;
            }
        }
        if (!res)
            System.out.println();
    }

    /**
     * 36 学校的位置
     */
    public static void xuexiaoweizhi() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] weizhi = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(weizhi);
        int juli = Integer.MAX_VALUE;
        int zuobiao = 0;
        for (int i = weizhi[0]; i <= weizhi[num - 1]; i++) {
            int count = 0;
            for (int j = 0; j < num; j++) {
                count += Math.abs(i - weizhi[j]);
            }
            if (juli > count) {
                juli = count;
                zuobiao = i;
            }
        }
        System.out.println(zuobiao);
    }

    /**
     * 36 学校的位置 满
     */
    public static void xuexiaoweizhi1() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] weizhi = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(weizhi);
        if (num % 2 == 0) {
            System.out.println(weizhi[num / 2 - 1]);
        } else {
            System.out.println(weizhi[num / 2]);
        }
    }

    /**
     * 35 预定酒店
     */
    public static void xuanzejiudian() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] jiage = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<JiuDian> list = new ArrayList<JiuDian>();
        for (int i = 0; i < lines[0]; i++) {
            JiuDian jiuDian = new JiuDian();
            jiuDian.setJiage(jiage[i]);
            jiuDian.setValue(Math.abs(jiage[i] - lines[2]));
            list.add(jiuDian);
        }
        list.sort((a, b) -> {
            if (a.getValue() != b.getValue()) {
                return a.getValue() - b.getValue();
            } else {
                return a.getJiage() - b.getJiage();
            }
        });
        List<JiuDian> collect = list.stream().limit(lines[1]).collect(Collectors.toList());
        collect.stream().sorted((a, b) -> a.getJiage() - b.getJiage()).forEach(a -> {
            System.out.print(a.getJiage() + " ");
        });
        System.out.println();
    }

    @Data
    public static class JiuDian {
        int jiage;
        int value;
    }

    /**
     * 34 工作安排
     * https://note.youdao.com/web/#/file/WEB1d22ba627f7285b7c4572edf7f914560/note/WEB5b7ab9a3e5bd088e8e18a464284a1bae/
     */
    public static void gongzuoanpai() {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt(); //列
        int num = sc.nextInt(); //行
        int[] t = new int[num];
        int[] v = new int[num];
        int[][] workValues = new int[num + 1][time + 1];// 从第一行开始（i=1），到第time列结束
        for (int i = 0; i < num; i++) {
            t[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for (int i = 1; i < num + 1; i++) {
            for (int j = 0; j < time + 1; j++) {
                if (t[i - 1] > j) {
                    workValues[i][j] = workValues[i - 1][j];//如果当前时间小于用工时间，则当前值等于上一行本列的值
                } else {
                    workValues[i][j] = Math.max(workValues[i - 1][j], workValues[i - 1][j - t[i - 1]] + v[i - 1]);//否则，比较上一行当前列的值 和 上一行总时间减去当前用工所需时间位置格子的值+当前值
                }
            }
        }
        System.out.println(workValues[num][time]);
    }

    /**
     * 33 相同数字的积木游戏1
     */
    public static void jimushuzijuli() {
        int num = 5;
        String lines = "1\n" +
                "\n" +
                "1\n" +
                "\n" +
                "3\n" +
                "\n" +
                "1\n" +
                "\n" +
                "4";
        List<String> list = Arrays.stream(lines.split("\n\n")).collect(Collectors.toList());
        int juli = -1;
        for (int i = 0; i < list.size(); i++) {
            int lI = list.lastIndexOf(list.get(i));
            if (lI > i) {
                juli = Math.max(juli, lI - i);
            }
        }
        System.out.println(juli);
    }

    /**
     * 32 租车骑绿道
     */
    public static void qiche() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[] tizhong = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(tizhong);
        int num = 0;
        for (int i = n - 1, j = 0; i >= 0 && j <= i; i--) {
            if (i == j) {
                num++;
                break;
            }
            if (tizhong[i] + tizhong[j] <= m) {
                tizhong[i] = 0;
                tizhong[j] = 0;
                j++;
                num++;
            } else {
                tizhong[i] = 0;
                num++;
            }
        }
        System.out.println(num);
    }

    /**
     * 31 优秀学员统计
     */
    public static void yuangongdaka() {
        Scanner sc = new Scanner(System.in);
        int ygNum = sc.nextInt();
        sc.nextLine();
        int[] dkNum = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, yuagong> map = new HashMap<Integer, yuagong>();
        for (int i = 0; i < ygNum; i++) {
            yuagong y = new yuagong();
            y.setId(i);
            y.setTime(31);
            y.setCount(0);
            map.put(i, y);
        }
        for (int i = 0; i < dkNum.length; i++) {
            int[] dkNumI = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < dkNumI.length; j++) {
                int id = dkNumI[j];
                yuagong yI = map.get(id);
                yI.setCount(yI.getCount() + 1);
                if (yI.getTime() == 31) {
                    yI.setTime(i);
                }
            }
        }
        List<yuagong> collect = map.values().stream().sorted((a, b) -> {
            if (b.getCount() > a.getCount()) {
                return b.getCount() - a.getCount();
            } else if (b.getCount() == a.getCount()) {
                if (a.getTime() > b.getTime()) {
                    return a.getTime() - b.getTime();
                } else if (a.getTime() == b.getTime()) {
                    return a.getId() - b.getId();
                }
            }
            return -1;
        }).filter(f -> f.getCount() > 0).collect(Collectors.toList());
        collect.stream()
                .limit(5).forEach(a -> {
                    System.out.print(a.getId() + " ");
                });
    }

    @Data
    public static class yuagong {
        int id;
        int time;
        int count;
    }

    /**
     * 30 找出通过车辆最多颜色
     */
    public static void cheliangyanse() {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int time = sc.nextInt();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < s.length - time + 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = i; j < time + i; j++) {
                map.put(s[j], map.getOrDefault(s[j], 0) + 1);
            }
            int temp = map.values().stream().sorted().collect(Collectors.toList()).get(map.size() - 1);
            res = res > temp ? res : temp;
        }
        System.out.println(res);
    }

    /**
     * 29 最多提取子串数目
     */
    public static void tiquzichuan() {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        List<String> a1 = Arrays.stream(A.split("")).collect(Collectors.toList());
        int count = 0;
        for (int i = 0; i < A.length() - B.length() + 1 && a1.size() > B.length(); i++) {
            int num = 0;
            for (int j = 0; j < B.length(); j++) {
                if (a1.indexOf(B.charAt(j) + "") > -1) {
                    a1.remove(B.charAt(j) + "");
                    num++;
                } else {
                    System.out.println(count);
                    return;
                }
            }
            if (num == B.length()) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }

    /**
     * 28 最左侧冗余覆盖子串
     *
     * @return
     */
    public static int zifuchaunzichuan() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int k = sc.nextInt();
        int len = s1.length() + k;
        for (int i = 0; i < s2.length() - len + 1; i++) {
            List<String> temp = Arrays.stream(s2.substring(i, i + len).split("")).collect(Collectors.toList());
            int count = 0;
            for (int j = 0; j < s1.length(); j++) {
                if (temp.indexOf(s1.charAt(j) + "") > -1) {
                    temp.remove(s1.charAt(j) + "");
                    count++;
                }
            }
            if (count == s1.length()) {
                System.out.println(i);
                return i;
            }
        }
        System.out.println(-1);
        return -1;
    }

    /**
     * 27 异常的打卡记录
     */
    public static void yuanGongRecord() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<Record> list = new ArrayList<Record>();
        List<String> res = new ArrayList<String>();
        Map<Integer, List<Record>> map = new HashMap<Integer, List<Record>>();
        for (int i = 0; i < num; i++) {
            String[] rec = sc.nextLine().split(",");
            Record record = new Record();
            record.setId(Integer.parseInt(rec[0]));
            record.setTime(Integer.parseInt(rec[1]));
            record.setDistance(Integer.parseInt(rec[2]));
            record.setActualId(rec[3]);
            record.setRegisterId(rec[4]);
            list.add(record);
            map.put(record.getId(), list);
        }
        map.entrySet().stream().forEach(entry -> {
            List<Record> records = entry.getValue();
            if (records.size() > 1) {
                for (int j = 0; j < records.size(); j++) {
                    Record record = records.get(j);
                    if (!record.getActualId().equals(record.getRegisterId())) {
                        res.add(record.toString());
                        continue;
                    }
                    for (int k = 0; k < records.size(); k++) {
                        if (j == k) continue;
                        Record record1 = records.get(k);
                        if (Math.abs(record1.getTime() - record.getTime()) < 60 && Math.abs(record1.getDistance() - record.getDistance()) > 5) {
                            res.add(record.toString());
                            continue;
                        }
                    }
                }
            }
        });

        System.out.println(String.join(";", res));
    }

    @Data
    public static class Record {
        private int id;
        private int time;
        private int distance;
        private String actualId;
        private String registerId;

        public Record() {

        }

        public Record(int id, int time, int distance, String actualId, String registerId) {
            this.id = id;
            this.time = time;
            this.distance = distance;
            this.actualId = actualId;
            this.registerId = registerId;
        }

        @Override
        public String toString() {
            return id +
                    "," + time +
                    "," + distance +
                    "," + actualId +
                    "," + registerId;
        }
    }

    /**
     * 26 箱子之形摆放
     */
    public static void baixiangzi() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        char[] xz = lines[0].toCharArray();
        int hang = Integer.parseInt(lines[1]);
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < hang; i++) {
            list.add(new StringBuilder());
        }
        int index = 0;
        boolean dist = true;
        for (int i = 0; i < xz.length; i++) {
            list.get(index).append(xz[i]);
            if ((i + 1) % hang == 0) {
                dist = !dist;
                continue;
            }
            if (dist) index++;
            else index--;
        }
        list.stream().forEach(a -> {
            System.out.println(a.toString());
        });
    }

    /**
     * 25 整理扑克牌
     */
    public static void zhaJinHua() {
        String[] strings = ("1\n" +
                "\n" +
                "1\n" +
                "\n" +
                "1\n" +
                "\n" +
                "2\n" +
                "\n" +
                "3\n" +
                "\n" +
                "3\n" +
                "\n" +
                "3\n" +
                "\n" +
                "4\n" +
                "\n" +
                "4\n" +
                "\n" +
                "4\n" +
                "\n" +
                "5\n" +
                "\n" +
                "5\n" +
                "\n" +
                "5").replace("\n\n", " ").split(" ");
        List<KaPai> list = new ArrayList<KaPai>();
        for (String s : strings) {
            KaPai first = list.stream().filter(a -> a.k == Integer.parseInt(s)).findFirst().orElse(null);
            if (first != null) {
                first.count++;
            } else {
                list.add(new KaPai(Integer.parseInt(s), 1));
            }
        }
        list.sort((a, b) -> {
            if (b.count > a.count) {
                return 1;
            } else if (a.count == b.count) {
                return b.k - a.k;
            } else return -1;
        });
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).count > 3) {
                for (int j = 0; j < list.get(i).count; j++) {
                    System.out.print(list.get(i).k + " ");
                }
                list.get(i).count = 0;
            } else if (list.get(i).count == 3) {
                for (int j = 0; j < list.get(i).count; j++) {
                    System.out.print(list.get(i).k + " ");
                }
                list.get(i).count = 0;
                i++;
                if (list.get(i).count == 3) {
                    System.out.print(list.get(i).k + " " + list.get(i).k + " ");
                    list.get(i).count = 1;
                } else if (list.get(i).count == 2) {
                    System.out.print(list.get(i).k + " " + list.get(i).k + " ");
                    list.get(i).count = 0;
                } else break;
            } else if (list.get(i).count == 2) {
                System.out.print(list.get(i).k + " " + list.get(i).k + " ");
                list.get(i).count = 0;
            } else break;
        }
        list.stream().filter(s -> s.count == 1).sorted((a, b) -> b.k - a.k).forEach(a -> System.out.print(a.k + " "));
    }

    public static class KaPai {
        int k;
        int count;

        public KaPai(int k, int count) {
            this.k = k;
            this.count = count;
        }
    }

    /**
     * 24 找数字
     */
    public static void zhaoShuZi() {
        Scanner sc = new Scanner(System.in);
        int hang = sc.nextInt();
        int lie = sc.nextInt();
        sc.nextLine();
        String[][] juzhen = new String[hang][lie];
        int[][] res = new int[hang][lie];
        Map<String, List<Integer[]>> map = new HashMap<String, List<Integer[]>>();
        for (int i = 0; i < hang; i++) {
            String[] lines = sc.nextLine().split(" ");
            juzhen[i] = lines;
            for (int j = 0; j < lines.length; j++) {
                String s = lines[j];
                List<Integer[]> list = map.get(s);
                if (list == null) {
                    list = new ArrayList<Integer[]>();
                }
                Integer[] zuobiao = new Integer[]{i, j};
                list.add(zuobiao);
                map.put(s, list);
            }
        }
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                res[i][j] = getJuZhenJuLi(juzhen, i, j, map);
            }
        }
        System.out.println(res);
    }

    public static int getJuZhenJuLi(String[][] juzhen, int i, int j, Map<String, List<Integer[]>> map) {
        String num = juzhen[i][j];
        List<Integer[]> list = map.get(num);
        int min = Integer.MAX_VALUE;
        for (Integer[] ints : list) {
            if (ints[0] != i || ints[1] != j) {
                int juli = Math.abs(ints[0] - i) + Math.abs(ints[1] - j);
                min = Math.min(min, juli);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * 23 任务总执行时长
     */
    public static void renWuZhiXingShiChang() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(",");
        int task1 = Integer.parseInt(lines[0]);
        int task2 = Integer.parseInt(lines[1]);
        int num = Integer.parseInt(lines[2]);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= num; i++) {
            int res = task1 * (num - i) + task2 * i;
            set.add(res);
        }
        System.out.println(set);
    }


    /**
     * 22 投篮大赛
     *
     * @return
     */
    public static int touLanDaSai() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < lines.length; i++) {
            String s = lines[i];
            if ((s.equals("C") || s.equals("D")) && list.size() == 0) return -1;
            if (s.equals("+") && list.size() < 2) return -1;
            if (s.equals("C")) {
                list.remove(list.size() - 1);
            } else if (s.equals("D")) {
                list.add(list.get(list.size() - 1) * 2);
            } else if (s.equals("+")) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else {
                list.add(Integer.parseInt(s));
            }
        }
        sum = list.stream().reduce(Integer::sum).get();
        System.out.println(sum);
        return sum;
    }

    /**
     * 21 字符串解密
     */
    public static void jieMiString() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int len = getStrdisLength(s2);
        String res = "";
        String temp = "";
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c > 'f' && c <= 'z') {
                temp += c;
                if (i < s1.length() - 1) continue;
            }
            if (getStrdisLength(temp) > 0 && getStrdisLength(temp) <= len) {
                if (getStrdisLength(temp) > getStrdisLength(res)) {
                    res = temp;
                } else if (getStrdisLength(temp) == getStrdisLength(res) && temp.compareTo(res) > 0) {
                    res = temp;
                }
                temp = "";
            }
        }
        System.out.println(res.isEmpty() ? "Not Found" : res);
    }

    public static int getStrdisLength(String str) {
        return Arrays.stream(str.split("")).distinct().toArray().length;
    }

    /**
     * 20 最小的调整次数
     */
    public static void duilietiaozheng() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int reverse = 0;
        sc.nextLine();
        int index = 1;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < 2 * n; i++) {
            String[] s = sc.nextLine().split(" ");
            if (s.length == 1) {
                if (queue.peekFirst() != index) {
                    Object[] objects = queue.toArray();
                    Arrays.sort(objects);
                    queue.clear();
                    for (Object object : objects) {
                        int num = Integer.parseInt(object.toString());
                        queue.add(num);
                    }
                    reverse++;
                }
                queue.removeFirst();
                index++;
            } else {
                if (s[0].equals("head")) {
                    queue.addFirst(Integer.parseInt(s[2]));
                } else {
                    queue.addLast(Integer.parseInt(s[2]));
                }
            }
        }
        System.out.println(reverse);
    }

    /**
     * 18 寻找链表的中间结点
     */
    public static void centerNode() {
        Scanner sc = new Scanner(System.in);
        String[] meta = sc.nextLine().split(" ");
        int num = Integer.parseInt(meta[1]); //节点数量
        List<String> nodes = new ArrayList<String>();
        Map<String, Node> map = new HashMap<String, Node>();
        for (int i = 0; i < num; i++) {
            String[] strNode = sc.nextLine().split(" ");
            map.put(strNode[0], new Node(strNode[0], strNode[1], strNode[2]));
        }
        Node cur = map.get(meta[0]);
        while (true) {
            nodes.add(cur.data);
            if (cur.next.equals("-1")) {
                break;
            }
            cur = map.get(cur.next);
        }
        System.out.println(nodes.get(nodes.size() / 2));
    }

    public static class Node {
        String data;
        String addr;
        String next;

        public Node() {

        }

        public Node(String addr, String data, String next) {
            this.data = data;
            this.next = next;
            this.addr = addr;
        }
    }

    /**
     * 18 获取最大软件版本号
     */
    public static void bigVersion() {
        Scanner sc = new Scanner(System.in);
        String v1 = sc.nextLine();
        String v2 = sc.nextLine();
        String str1 = v1.split("-")[0];
        String str2 = v2.split("-")[0];
        int[] num1 = Arrays.stream(str1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] num2 = Arrays.stream(str2.split("\\.")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 3; i++) {
            if (i < num1.length && i < num2.length) {
                if (num1[i] > num2[i]) {
                    System.out.println(v1);
                    return;
                } else if (num1[i] < num2[i]) {
                    System.out.println(v2);
                    return;
                }
            } else {
                System.out.println(str1.compareTo(str2) > 0 ? v1 : v2);
                return;
            }
        }
        if (v1.split("-").length == 2 && v2.split("-").length == 2) {
            String beta1 = v1.split("-")[1];
            String beta2 = v2.split("-")[1];
            System.out.println(beta1.compareTo(beta2) > 0 ? v1 : v2);
        } else {
            System.out.println(v1);
        }
    }

    /**
     * 17 开心消消乐
     */
    public static void reverseJuZhen() {
        int hang = 3, lie = 3;
        String[] str = String.format(
                        "1 0 1\n" +
                                "\n" +
                                "0 1 0\n" +
                                "\n" +
                                "1 0 1"
                )
                .replace("\n\n", " ").split(" ");

        String[][] lines = new String[hang][lie];
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                lines[i][j] = str[i * lie + j];
            }
        }
        int num = 0;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (lines[i][j].equals("1")) {
                    reverseJuZhenNode(lines, i, j);
                    num++;
                }
            }
        }
        System.out.println(num);
    }

    public static void reverseJuZhenNode(String[][] lines, int i, int j) {
        int hang = lines.length;
        int lie = lines[0].length;
        if (i < 0 || i >= hang || j < 0 || j >= lie || lines[i][j].equals("0")) {
            return;
        }
        lines[i][j] = "0";
        reverseJuZhenNode(lines, i - 1, j - 1);
        reverseJuZhenNode(lines, i - 1, j);
        reverseJuZhenNode(lines, i - 1, j + 1);
        reverseJuZhenNode(lines, i, j - 1);
        reverseJuZhenNode(lines, i, j + 1);
        reverseJuZhenNode(lines, i + 1, j - 1);
        reverseJuZhenNode(lines, i + 1, j);
        reverseJuZhenNode(lines, i + 1, j + 1);
    }

    /**
     * 16 网上商城优惠活动（一）
     */
    public static void shangpindazhe() {
        Scanner scanner = new Scanner(System.in);
        int manjian = scanner.nextInt();//满100减10 数量
        int dazhe = scanner.nextInt();//打92折，限用一张
        int wumenkan = scanner.nextInt();//无门槛减5元 数量
        int renshu = scanner.nextInt(); //人数
        List<Integer[]> list = new ArrayList<Integer[]>();
        for (int i = 0; i < renshu; i++) {
            int jiage = scanner.nextInt();
            int youhuijia = Integer.MAX_VALUE;
            int yhjsl = Integer.MAX_VALUE;
            int youhuijiaT = 0;
            //满减+打折
            int mjNum = jiage / 100 > manjian ? manjian : jiage / 100;
            if (dazhe > 0) {
                youhuijiaT = (int) Math.floor((jiage - mjNum * 10) * 0.92);
                if (youhuijia > youhuijiaT) {
                    youhuijia = youhuijiaT;
                    yhjsl = mjNum + 1;
                }
            }
            //满减+无门槛
            youhuijiaT = (int) Math.floor(jiage - mjNum * 10) - wumenkan * 5;
            if (youhuijiaT < 0) { //特殊情况，优惠到0
                youhuijia = 0;
                yhjsl = yhjsl > (mjNum + (jiage + 4) / 5) ? mjNum + (jiage + 4) / 5 : yhjsl;
            } else {
                if (youhuijia > youhuijiaT) {
                    youhuijia = youhuijiaT;
                    yhjsl = mjNum + wumenkan;
                } else if (youhuijia == youhuijiaT) {
                    yhjsl = yhjsl > (mjNum + wumenkan) ? mjNum + wumenkan : yhjsl;
                }
            }
            //打折+满减
            youhuijiaT = (int) Math.floor(jiage * 0.92);
            mjNum = youhuijiaT / 100 > manjian ? manjian : youhuijiaT / 100;
            youhuijiaT -= mjNum * 10;
            if (youhuijia > youhuijiaT) {
                youhuijia = youhuijiaT;
                yhjsl = mjNum + +1;
            } else if (youhuijia == youhuijiaT) {
                yhjsl = yhjsl > (mjNum + 1) ? mjNum + 1 : yhjsl;
            }
            //打折+无门槛
            youhuijiaT = (int) Math.floor(jiage * 0.92) - wumenkan * 5;
            if (youhuijiaT < 0) { //特殊情况，优惠到0
                youhuijia = 0;
                yhjsl = yhjsl > (1 + (jiage + 4) / 5) ? 1 + (jiage + 4) / 5 : yhjsl;
            } else {
                if (youhuijia > youhuijiaT) {
                    youhuijia = youhuijiaT;
                    yhjsl = 1 + wumenkan;
                } else if (youhuijia == youhuijiaT) {
                    yhjsl = yhjsl > (1 + wumenkan) ? 1 + wumenkan : yhjsl;
                }
            }
            list.add(new Integer[]{youhuijia, yhjsl});
            System.out.println(youhuijia + " " + yhjsl);
        }
        System.out.println(list);
    }

    /**
     * 15 通信误码
     */
    public static void zuiduanArraywuma() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        int[] nums = Arrays.stream(lines).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
            max = Math.max(max, count + 1);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) result.add(entry.getKey());
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            int start = list.indexOf(result.get(i));
            int end = list.lastIndexOf(result.get(i));
            min = Math.min(min, end - start + 1);
        }
        System.out.println(min);
    }

    /**
     * 14 数组的中心位置
     */
    public static void arrayCenter() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        int[] nums = Arrays.stream(lines).mapToInt(Integer::parseInt).toArray();
        int ji = Arrays.stream(nums).reduce((a, b) -> a * b).getAsInt();
        int left = 1, right = ji, index = 0;
        for (int i = 0; i < nums.length; i++) {
            right /= nums[i];
            if (i > 0) {
                left *= nums[i - 1];
            }
            index = i;
            if (left == right) break;
        }
        System.out.println(index);
    }

    /**
     * 13 日志采集系统
     *
     * @return
     */
    public static int logfenshu1() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        int[] nums = Arrays.stream(lines).mapToInt(Integer::parseInt).toArray();
        int pre, koufen = 0, total = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = total;//前一位总数
            total += nums[i];//当前总数
            koufen += pre;//需要扣除的分数
            if (total >= 100) {
                total = 100;
                max = Math.max(max, total - koufen);//总分
                break;
            }
            max = Math.max(max, total - koufen);
        }
        return max;
    }

    /**
     * 13 日志采集系统
     *
     * @return
     */
    public static int logfenshu() {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = nums[0];
        if (nums[0] >= 100) return 100;
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int log = nums[i];
            count += log;
            if (count >= 100) {
                sum = Math.max(100 - koufen(nums, i), sum);
                break;
            } else {
                sum = Math.max(count - koufen(nums, i), sum);
            }
        }
        return sum;
    }

    public static int koufen(int[] nums, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += nums[i] * (index - i);
        }
        return sum;
    }

    /**
     * 12 简单的自动曝光
     */
    public static void zidongbaoguang() {
        Scanner sc = new Scanner(System.in);//255 0 0 0
        String[] lines = sc.nextLine().split(" ");
        int[] nums = Arrays.stream(lines).mapToInt(Integer::parseInt).toArray();
        int len = nums.length;
        int sum = 128 * len;
        int abs = Integer.MAX_VALUE;
        int res = 0;
        for (int i = -127; i < 129; i++) {
            int sumT = 0;
            for (int j = 0; j < len; j++) {
                int temp = i + nums[j] < 0 ? 0 : i + nums[j] > 255 ? 255 : i + nums[j];
                sumT += temp;
            }
            if (abs > Math.abs(sum - sumT)) {
                abs = Math.abs(sum - sumT);
                res = i;
            }
        }
        System.out.println(res);
    }

    /**
     * 11 完美走位
     */
    public static void wanmeizouwei() {
        String s = "AASW";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int avg = s.length() / 4;
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > avg) {
                res += entry.getValue() - avg;
            }
        }
        System.out.println(res);
    }

    /**
     * 10 货币单位换算
     */
    public static void huobizhuanhuan() {
        int num = 2;
        String[] lines = (
                "20CNY53fen\n" +
                        "\n" +
                        "53HKD87cents"
        ).split("\n\n");
        double count = 0;
        for (int i = 0; i < num; i++) {
            String line = lines[i];
            String[] split = line.split("\\d");
            for (String s : split) {
                if (s.isEmpty()) continue;
                String no = line.substring(0, line.indexOf(s));
                count += huansuan(no, s.charAt(0));
                line = line.substring(line.indexOf(s) + s.length());
            }
        }
        System.out.println(Math.round(Math.floor(count)));
    }

    public static double huansuan(String numStr, char str) {
        double count = 0;
        int num = Integer.valueOf(numStr);
        if (str == 'C') {
            count = num * 100;
        } else if (str == 'J') {
            count = (double) num * 10000 / 1825;
        } else if (str == 'H') {
            count = (double) num * 10000 / 123;
        } else if (str == 'E') {
            count = (double) num * 10000 / 14;
        } else if (str == 'G') {
            count = (double) num * 10000 / 12;
        } else if (str == 'f') {
            count = num * 1;
        } else if (str == 's') {
            count = (double) num * 100 / 1825;
        } else if (str == 'c') {
            count = (double) num * 100 / 123;
        } else if (str == 'e') {
            count = (double) num * 100 / 14;
        } else if (str == 'p') {
            count = (double) num * 100 / 12;
        }
        return count;
    }

    /**
     * 9 关联端口组合并
     */
    public static void shuzujiaoji() {
        int num = 6;
        String[] str = (
                "10\n" +
                        "\n" +
                        "4,2,1\n" +
                        "\n" +
                        "9\n" +
                        "\n" +
                        "3,6,9,2\n" +
                        "\n" +
                        "6,3,4\n" +
                        "\n" +
                        "8"
        ).split("\n\n");
        List<Set<Integer>> list = new ArrayList<Set<Integer>>();
        for (int i = 0; i < num; i++) {
            int[] duankou = Stream.of(str[i].split(",")).mapToInt(Integer::parseInt).toArray();
            Set<Integer> set = new HashSet<Integer>();
            if (duankou.length == 1) {
                set.add(duankou[0]);
                list.add(set);
            } else {
                for (int i1 : duankou) {
                    set.add(i1);
                }
                list.add(set);
                merge2Set(list, set, list.size() - 1);
            }
        }
        System.out.println(list);
    }

    public static void merge2Set(List<Set<Integer>> list, Set<Integer> set, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (i == index) continue;
            Set<Integer> temp = new HashSet<>();
            Set<Integer> seti = list.get(i);
            temp.addAll(set);
            temp.retainAll(seti);
            if (temp.size() > 1) {
                int before = index < i ? index : i;
                int after = index < i ? i : index;
                set.addAll(seti);
                list.remove(after);
                list.remove(before);
                list.add(before, set);
                merge2Set(list, set, before);
            }
        }
    }

    /**
     * 8 分界线  匹配两个字符串
     *
     * @param news
     * @param letters
     * @return
     */
    public static boolean newspaper2anonymousLetter(String news, String letters) {
        String[] newspaper = news.split(" ");
        String[] anonymousLetter = letters.split(" ");
        for (String s : anonymousLetter) {
            for (int i = 0; i < newspaper.length; i++) {
                String n = newspaper[i];
                if (s.length() == n.length() && change(s, n)) {
                    newspaper[i] = "";
                    break;
                }
                if (i == newspaper.length - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 7 对称字符串
     */
    public static void getStringSiteChar() {
        int hang = 1;
        String[] ques = (
                "58 15082511951509046"
        ).split("\n\n");
        List<long[]> list = new ArrayList<long[]>();
        for (int i = 0; i < hang; i++) {
            int n = Integer.parseInt(ques[i].split(" ")[0]);//第几个字符串 1开始
            if (n == 1) {
                System.out.println("red");
                continue;
            }
            long k = Long.parseLong(ques[i].split(" ")[1]);//字符下标 0开始
            boolean reverse = false; //是否反转
            while (n > 0) {
                if (n == 1) {
                    if (reverse) {
                        System.out.println("blue");
                    } else {
                        System.out.println("red");
                    }
                }
                long charNum = (long) Math.pow(2, n - 2);       //第n-1行的总字符个数
                if (k < charNum) {
                    reverse = !reverse;
                } else {
                    k -= charNum;
                }
                n--;
            }
        }
    }

    /**
     * 6 打印文件
     */
    public static void dayinji() {
        int num = 5;
        String[] s = (
                "IN 1 1\n" +
                        "\n" +
                        "IN 1 3\n" +
                        "\n" +
                        "IN 1 1\n" +
                        "\n" +
                        "IN 1 3\n" +
                        "\n" +
                        "OUT 1"
        ).split("\n\n");
        Map<String, List<int[]>> map = new HashMap<String, List<int[]>>();
        int no = 0;
        for (int i = 0; i < num; i++) {
            String[] in = s[i].split(" ");
            if (s[i].indexOf("IN") != -1) {
                int[] queue = new int[2];
                queue[0] = Integer.parseInt(in[2]);
                queue[1] = ++no;
                if (map.containsKey(in[1])) {
                    map.get(in[1]).add(queue);
                } else {
                    List<int[]> res = new ArrayList<int[]>();
                    res.add(queue);
                    map.put(in[1], res);
                }
            } else {
                if (!map.containsKey(in[1]) || map.get(in[1]).size() == 0) {
                    System.out.println("NULL");
                } else {
                    List<int[]> queue = map.get(in[1]);
                    queue.sort((a, b) -> b[0] - a[0]);
                    System.out.println(queue.get(0)[1]);
                    queue.remove(0);
                }
            }
        }
    }

    /**
     * 5 单词倒序
     *
     * @param s
     * @return
     */
    public static String reverseStrings(String s) {
        String[] args = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append(reverseString(args[i]) + " ");
        }
        return sb.toString().substring(0, s.length());
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        String res = "";
        String temp = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            if (" .,?".indexOf(chars[i]) != -1) {
                temp = temp + chars[i];
            } else
                res += chars[i];
        }
        return res + temp;
    }

    static int ruKouCount = 0;
    static int quyuSize = 0;

    /**
     * 4 查找单入口空闲区域
     */
    public static void getDanRuKou() {
        int m = 4, n = 4;
        String s = String.format(
                        "X X X X\n" +
                                "X O O X\n" +
                                "X O O X\n" +
                                "X O X X"
                )
                .replace("\n", " ");
        String[] sArr = s.split(" ");
        String[][] strings = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                strings[i][j] = sArr[i * n + j];
            }
        }
        int[] quyu = null;
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].length; j++) {
                boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (isEdge && strings[i][j].equals("O")) {
                    ruKouCount = 0;
                    quyuSize = 0;
                    qiuquyu(strings, i, j);
                    if (ruKouCount == 1) {
                        if (quyuSize == max) {
                            quyu = null;
                        } else if (quyuSize > max) {
                            quyu = new int[]{i, j, quyuSize};
                            max = quyuSize;
                        }
                    }
                }
            }
        }
        if (quyu != null) {
            System.out.println(quyu[0] + " " + quyu[1] + " " + quyu[2]);
        } else if (max != 0) {
            System.out.println(max + "");
        } else {
            System.out.println("NULL");
        }
    }

    public static void qiuquyu(String[][] strings, int i, int j) {
        int m = strings.length, n = strings[0].length;
        if (i < 0 || j < 0 || j >= n || i >= m || strings[i][j].equals("X")) {
            return;
        }
        boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
        if (isEdge && strings[i][j].equals("O")) {
            ruKouCount++;
        }
        strings[i][j] = "X";
        quyuSize++;
        qiuquyu(strings, i - 1, j);
        qiuquyu(strings, i + 1, j);
        qiuquyu(strings, i, j - 1);
        qiuquyu(strings, i, j + 1);
    }

    /**
     * 3 查找重复代码
     *
     * @param source
     * @param target
     * @return
     */
    public static String commonCode(String source, String target) {
        String[] ch = source.split("");
        String[] ta = target.split("");
        String res = "";
        for (int i = 0; i < ch.length; i++) {
            String c = ch[i];
            int index = target.indexOf(c);
            if (index != -1) {
                int k = i + 1;
                for (int j = index + 1; j < ta.length && k < ch.length && ch[k].equals(ta[j]); k++, j++) ;
                if (res.length() < k - i) {
                    res = source.substring(i, k);
                }
            }
        }
        return res;
    }

    /**
     * 2 木板
     *
     * @param n
     * @param m
     * @param nums
     * @return
     */
    public static int muban(int n, int m, int[] nums) {
        if (n == 1) return nums[0];
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (m <= 0) break;
            if (nums[i - 1] < nums[i]) {
                nums[i - 1] += 1;
                i = i == 1 ? i - 1 : i - 2;
                m--;
            }
        }
        return nums[0];
    }

    /**
     * 1 猜字谜
     *
     * @param mimian
     * @param midi
     * @return
     */
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
