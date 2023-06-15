package com.example.demo;

import org.jetbrains.annotations.NotNull;

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
//            shejibisai();
//            zhaozhongdian();
//            zifuchuanjiami();
//            zuiyuanzuji();
//            zuichangshunzi();
//            baowenchongpai();
//            shitanggongcan();
//            wuziqi();
//            dancijielong();
//            bisaidafen();
//            xiaoxiduilie();
//            zuichanghouzhui();
//            zuishaojiaohuan();
//            cipanpaixu();
//            panduanbudengshi();
//            liangshuzhihejueduizhi();
//            shuzupinjie();
//            xiangduikaiyinjie();
//            juxingxiangjiaomianji();
//            liushuixian();
//            redianwangzhantongji();
//            jianshiqi();
        }
        while (true) {
//            alibbzhaobaoxiang3();
//            alibbzhaobaoxiang2();
//            daimaEditor();
//            TLVjiema();
//            shujufenlei();
//            alibbzhaoBaoxiang5();
//            stringStatistics();
//            jingdianpingbao();
//            guanyajijun();
//            VLANziyuanchi();
//            shuzixulie();
            duoshuzhihe();
        }
    }


    //int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    public static void yijuxingqiugaizao() {
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<String>();
        String[][] source = new String[][]{};
        while (sc.hasNext()) {
            lines.add(sc.nextLine());
        }
        for (int i = 0; i < lines.size(); i++) {
            source[i] = lines.get(i).split(" ");
        }
        String[][] temp = Arrays.copyOf(source, source.length);
        int row = temp.length;
        int column = temp[0].length;
        int day = 0;
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (source[i][j] == "YES") {
                        if (xingqiugaizao(temp, i, j)) {
                            found = true;
                        }
                    }
                }
            }
            day++;
            source = Arrays.copyOf(temp, source.length);
        }
    }

    public static boolean xingqiugaizao(String[][] temp, int i, int j) {
        boolean found = false;
        if (i > 0 && temp[i - 1][j].equals("NO")) {
            temp[i - 1][j] = "YES";
            found = true;
        }
        if (i < temp.length && temp[i + 1][j].equals("NO")) {
            temp[i + 1][j] = "YES";
            found = true;
        }
        if (j > 0 && temp[i][j - 1].equals("NO")) {
            temp[i][j - 1] = "YES";
            found = true;
        }
        if (j < temp[0].length && temp[i][j + 1].equals("NO")) {
            temp[i][j + 1] = "YES";
            found = true;
        }
        return found;
    }


////////////////////////////////////////初阶////////////////////////////////////////

    /**
     * 65  判断字符串子序列
     */
    public static void stringzixulie() {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String source = sc.nextLine();
        int index = source.length() - 1;
        for (int i = target.length() - 1; i >= 0; i--) {
            char c = target.charAt(i);
            boolean found = false;
            for (int j = index; j >= 0; j--) {
                char ch = source.charAt(j);
                if (c == ch) {
                    found = true;
                    index = j - 1;
                    break;
                }
            }
            if (!found) {
                System.out.println(-1);
                return;
            }
            if (i == 0) {
                System.out.println(index + 1);
                return;
            }
        }
    }

    /**
     * 64  勾股数元组
     */
    public static void gougushuyuanzu() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean flag = true;
        for (int i = n; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m + 1; k++) {
                    if (i * i + j * j < k * k) {
                        break;
                    } else if (i * i + j * j == k * k) {
                        if (iszhishu(i, j) && iszhishu(j, k) && iszhishu(i, k)) {
                            System.out.println(i + " " + j + " " + k);
                            flag = false;
                        }
                    }
                }
            }
        }
        if (flag) {
            System.out.println("NA");
        }
    }

    public static boolean iszhishu(int a, int b) {
        int yushu = 0;
        while (a % b != 0) {
            yushu = a % b;
            a = b;
            b = yushu;
        }
        return b == 1;
    }

    /**
     * 63  恢复数字序列
     */
    public static void huifushuzixulie() {
        Scanner sc = new Scanner(System.in);
        long[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long shulie = lines[0];
        String shulieStr = Arrays.stream((shulie + "").split("")).sorted().collect(Collectors.joining(""));
        int n = (int) lines[1];
        for (int i = 1; i < 1000; i++) {
            String temp = "";
            for (int j = i; j < n + i; j++) {
                temp += j;
            }
            temp = Arrays.stream(temp.split("")).sorted().collect(Collectors.joining(""));
            if (temp.equals(shulieStr)) {
                System.out.println(i);
                return;
            }
        }

    }

    /**
     * 62  ai面板识别
     */
    public static void aimianbanshibie() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Panel> list = new ArrayList<Panel>();
        for (int i = 0; i < n; i++) {
            int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Panel panel = new Panel(lines[0], lines[1], lines[2], lines[3], lines[4]);
            list.add(panel);
        }
        Collections.sort(list);
        Panel jizhun = list.get(0);
        int banjing = (jizhun.y2 - jizhun.y1) / 2;
        for (int i = 1; i < list.size(); i++) {
            Panel panel = list.get(i);
            if (panel.y1 - jizhun.y1 <= banjing) {
                panel.y1 = jizhun.y1;
                panel.y2 = jizhun.y2;
            } else {
                jizhun = panel;
            }
        }
        Collections.sort(list);
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).id + " ";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }

    static class Panel implements Comparable<Panel> {
        int id;
        int x1;
        int y1;
        int x2;
        int y2;

        public Panel(int id, int x1, int y1, int x2, int y2) {
            this.id = id;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public int compareTo(@NotNull Panel o) {
            if (this.y1 == o.y1) {
                return this.x1 - o.x1;
            }
            return this.y1 - o.y1;
        }
    }

    /**
     * 61 支持优先级的队列
     */
    public static void youxianjiduilie() {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] lines = in.substring(1, in.length() - 1).split("\\),\\(");
        Set<String> set = new HashSet<String>();
        List<Task> list = new ArrayList<Task>();
        set.addAll(Arrays.asList(lines));
        set.forEach(s -> {
            Task task = new Task();
            task.num = Integer.parseInt(s.split(",")[0]);
            task.power = Integer.parseInt(s.split(",")[1]);
            task.index = list.size();
            list.add(task);
        });
        Collections.sort(list);
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).num + "");
        }
        System.out.println(String.join(",", res));
    }

    static class Task implements Comparable<Task> {
        int index;
        int num;
        int power;

        @Override
        public int compareTo(@NotNull Task o) {
            if (this.power == o.power) {
                return this.index - o.index;
            }
            return o.power - this.power;
        }
    }

    /**
     * 60 矩阵最大值
     */
    public static void juzhenzuidazhi() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int res = 0;
        for (int i = 0; i < n; i++) {
            String si = sc.nextLine().replace(",", "");
            int max = 0;
            for (int j = 0; j < n; j++) {
                String sj = si.substring(j) + si.substring(0, j);
                int num = Integer.parseInt(sj, 2);
                max = Math.max(max, num);
            }
            res += max;
        }
        System.out.println(res);
    }

    /**
     * 59  矩阵稀疏扫描
     */
    public static void juzhenxishusaomiao() {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        String srow = String.format("%" + col / 2 + "s", "");
        String scol = String.format("%" + row / 2 + "s", "");
        srow = srow.replaceAll("\\s", "0");
        scol = scol.replaceAll("\\s", "0");
        int rnum = 0;
        int cnum = 0;
        int[][] lines = new int[row][col];
        int[][] lines1 = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int in = sc.nextInt();
                lines[i][j] = in;
                lines1[j][i] = in;
            }
            String tRow = String.join("", Arrays.stream(lines[i]).boxed().map(String::valueOf).collect(Collectors.toList()));
            if (tRow.contains(srow)) {
                rnum++;
            }
        }
        for (int i = 0; i < lines1.length; i++) {
            String tCol = String.join("", Arrays.stream(lines1[i]).boxed().map(String::valueOf).collect(Collectors.toList()));
            if (tCol.contains(scol)) {
                cnum++;
            }
        }
        System.out.println(rnum);
        System.out.println(cnum);
    }

    /**
     * 58  最长连续子序列
     */
    public static void zuichanglianxuzixulie() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int sum = sc.nextInt();
        int max = -1;
        int temp = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == sum) {
                max = Math.max(max, 1);
                continue;
            }
            temp = lines[i];
            for (int j = i + 1; j < lines.length; j++) {
                temp += lines[j];
                if (temp == sum) {
                    max = Math.max(max, j - i + 1);
                } else if (temp > sum) {
                    break;
                }
            }
        }
        System.out.println(max);
    }

    /**
     * 57 计算最大乘积
     */
    public static void jisuanzuidachengji() {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int max = 0;
        for (int i = 0; i < s.length; i++) {
            String si = s[i];
            for (int j = i + 1; j < s.length; j++) {
                Set<String> set = new HashSet<String>();
                set.addAll(Arrays.asList(si.split("")));
                String sj = s[j];
                set.addAll(Arrays.asList(sj.split("")));
                if (set.size() == si.length() + sj.length()) {
                    max = Math.max(max, si.length() * sj.length());
                }
            }
        }
        System.out.println(max);

    }

    /**
     * 56  数大雁
     */
    public static void shudayan() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int max = 0;
        int Q = 0, U = 0, A = 0, C = 0, K = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'q') {
                Q++;
            } else if (c == 'u') {
                U++;
            } else if (c == 'a') {
                A++;
            } else if (c == 'c') {
                C++;
            } else if (c == 'k') {
                K++;
            } else {
                System.out.println(-1);
                return;
            }
            if (Q >= U && U >= A && A >= C && C >= K) {
                max = Math.max(max, Q - K);
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(max);
    }

    /**
     * 55  数字反转打印
     */
    public static void shuzifanzhuandayin() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> lists = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            int fi = firstNum(i);
            if (i > 1) {
                for (int j = 0; j < lists.size(); j++) {
                    lists.set(j, "    " + lists.get(j));
                }
            }
            List<String> list = new ArrayList<>();
            for (int j = 1; j < i + 1; j++) {
                if (i % 2 == 0) {
                    list.add(0, stringRightPad(fi++));
                } else {
                    list.add(stringRightPad(fi++));
                }
            }
            String temp = String.join("    ", list);
            lists.add(temp);
        }
        lists.forEach(System.out::println);
    }

    public static int firstNum(int i) {
        if (i == 1) return 1;
        return firstNum(i - 1) + i - 1;
    }

    public static String stringRightPad(int s) {
        return stringRightPad(s + "");
    }

    public static String stringRightPad(String s) {
        String str = s + "***";
        return str.substring(0, 4);
    }

    /**
     * 54 求符合条件元组个数
     */
    public static void duoshuzhihe() {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int count = sc.nextInt();
        int target = sc.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        duoshuzhiheBackTracking(list, new ArrayList<>(), target, count, 0, res);
        System.out.println(res.size());
    }

    public static void duoshuzhiheBackTracking(List<Integer> list, List<Integer> temp, int target, int count, int index, List<List<Integer>> res) {
        if (temp.size() == count || index == list.size()) {
            int sum = temp.stream().reduce(Integer::sum).get();
            List<Integer> tempList = new ArrayList<>(temp);
            Collections.sort(tempList);
            if (sum == target && !res.contains(tempList)) {
                res.add(tempList);
            }
        } else {
            for (int i = index; i < list.size(); i++) {
                if (temp.contains(list.get(i))) {
                    continue;
                }
                temp.add(list.get(i));
                duoshuzhiheBackTracking(list, temp, target, count, ++index, res);
                temp.remove(list.get(i));
            }
        }
    }

    /**
     * 53 	非严格递增连续数字序列
     */
    public static void shuzixulie() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int max = 0;
        int temp = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (Character.isDigit(s.charAt(i - 1)) && c >= s.charAt(i - 1)) {
                    temp++;
                } else {
                    max = Math.max(max, temp);
                    temp = 1;
                }
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        System.out.println(max);
    }

    /**
     * 52 VLAN资源池
     */
    public static void VLANziyuanchi() {
        Scanner sc = new Scanner(System.in);
        List<String> vlans = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());
        int vl = sc.nextInt();
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < vlans.size(); i++) {
            String v = vlans.get(i);
            if (v.contains("-")) {
                int l = Integer.parseInt(v.split("-")[0]);
                int r = Integer.parseInt(v.split("-")[1]);
                for (int j = l; j <= r; j++) {
                    ans.add(j);
                }
            } else {
                ans.add(Integer.parseInt(v));
            }
        }
        if (ans.contains(vl)) {
            ans.remove(ans.indexOf(vl));
        }
        vlans.clear();
        String temp = "";
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            if (i < ans.size() - 1) {
                if (temp.equals("")) {
                    if (ans.get(i) + 1 == ans.get(i + 1)) {
                        temp = ans.get(i) + "-";
                    } else {
                        vlans.add(ans.get(i) + "");
                    }
                } else {
                    if (ans.get(i) + 1 == ans.get(i + 1)) {
                        continue;
                    } else {
                        vlans.add(temp + ans.get(i));
                        temp = "";
                    }
                }

            } else {
                if (temp.equals("")) {
                    vlans.add(ans.get(i) + "");
                } else {
                    vlans.add(temp + ans.get(i));
                }
            }
        }
        System.out.println(String.join(",", vlans));
    }

    /**
     * 51 比赛的冠亚季军
     */
    public static void guanyajijun() {
        Scanner sc = new Scanner(System.in);
        List<Integer> lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Player> list = new ArrayList<Player>();
        for (int i = 0; i < lines.size(); i++) {
            Player player = new Player(i, lines.get(i));
            list.add(player);
        }
        wins.clear();
        loses.clear();
        guanyajijunHandle(list);
        Collections.sort(wins);
        Collections.sort(loses);
        String result = "";
        for (int i = 0; i < wins.size(); i++) {
            result += wins.get(i).no + " ";
        }
        System.out.println(result + loses.get(0).no);
    }

    static List<Player> wins = new ArrayList<>();
    static List<Player> loses = new ArrayList<>();

    public static void guanyajijunHandle(List<Player> list) {
        if (list.size() == 0) return;
        List<Player> resList = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 2) {
            if (i == list.size() - 1) {
                if (list.size() <= 4) {
                    wins.add(list.get(i));
                } else {
                    resList.add(list.get(i));
                }
                break;
            }
            if (list.size() <= 4) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    wins.add(list.get(i + 1));
                    loses.add(list.get(i));
                } else {
                    wins.add(list.get(i));
                    loses.add(list.get(i + 1));
                }
            } else {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    resList.add(list.get(i + 1));
                } else {
                    resList.add(list.get(i));
                }
            }
        }
        guanyajijunHandle(resList);
    }

    static class Player implements Comparable<Player> {
        int no;
        int power;

        public Player(int no, int power) {
            this.no = no;
            this.power = power;
        }

        @Override
        public int compareTo(@NotNull Player o) {
            if (o.power == this.power) {
                return this.no - o.no;
            }
            return o.power - this.power;
        }
    }

    /**
     * 51 经典屏保
     */
    public static void jingdianpingbao() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int t = sc.nextInt();
        int xd = 1, yd = 1;
        for (int i = 0; i < t; i++) {
            if (x == 0) {
                xd = 1;
            }
            if (x == 750) {
                xd = -1;
            }
            if (y == 0) {
                yd = 1;
            }
            if (y == 575) {
                yd = -1;
            }
            x += xd;
            y += yd;
        }
        System.out.println(x + " " + y);
    }

    /**
     * 49 字符串统计
     */
    public static void stringStatistics() {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("@");
        if (s.length == 1) {
            System.out.println(s[0]);
        } else {
            Map<String, Integer> map = new HashMap<String, Integer>();
            Map<String, Integer> map1 = new HashMap<String, Integer>();
            for (int i = 0; i < s[0].split(",").length; i++) {
                String[] para = s[0].split(",")[i].split(":");
                map.put(para[0], Integer.parseInt(para[1]));
            }
            for (int i = 0; i < s[1].split(",").length; i++) {
                String[] para = s[1].split(",")[i].split(":");
                map1.put(para[0], Integer.parseInt(para[1]));
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (map1.get(entry.getKey()) != null) {
                    if (map1.get(entry.getKey()) != entry.getValue()) {
                        map.put(entry.getKey(), entry.getValue() - map1.get(entry.getKey()));
                    } else if (entry.getValue() == map1.get(entry.getKey())) {
                        map.remove(entry.getKey());
                    }
                }
            }
            List<String> res = new ArrayList<String>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                res.add(entry.getKey() + ":" + entry.getValue());
            }
            System.out.println(String.join(",", res));
        }
    }

    /**
     * 48 阿里巴巴找黄金宝箱(V)
     */
    public static void alibbzhaoBaoxiang5() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lines.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += lines[j];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    /**
     * 47 数据分类
     */
    public static void shujufenlei() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 2; i < lines.length; i++) {
            int c = lines[0];
            int b = lines[1];
            String s = String.format("%08x", lines[i]);
            int sum = 0;
            for (int j = 0; j < 7; j += 2) {
                sum += Integer.parseInt(s.substring(j, j + 2), 16);
            }
            if (sum % b < c) {
                map.put(sum % b, map.getOrDefault(sum % b, 0) + 1);
            }
        }
        int max = map.entrySet().stream().max((a, b) -> a.getValue() - b.getValue()).map(e -> e.getValue()).get();
        System.out.println(max);
    }

    public static void TLVjiema() {
        Scanner sc = new Scanner(System.in);
        String tag = sc.nextLine();
        String[] codes = sc.nextLine().split(" ");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < codes.length; i++) {
            int len = Integer.parseInt(codes[i + 2] + codes[i + 1], 16);
            if (codes[i].equals(tag)) {
                i += 3;
                for (int j = i; j < len + i; j++) {
                    list.add(codes[j]);
                }
                break;
            }
            i += 2 + len;
        }
        System.out.println(String.join(" ", list));
    }

    /**
     * 45 代码编辑器
     */
    public static void daimaEditor() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String content = sc.nextLine();
        int start = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String zl = s.split(" ")[0];
            String x = s.split(" ")[1];
            switch (zl) {
                case "FORWARD":
                    int r = Integer.parseInt(x);
                    if (r > content.length() - start) {
                        start = content.length();
                    } else {
                        start += r;
                    }
                    break;
                case "BACKWARD":
                    int l = Integer.parseInt(x);
                    if (l > start) {
                        start = 0;
                    } else {
                        start -= l;
                    }
                    break;
                case "SEARCH-FORWARD":
                    String ls = content.substring(0, start);
                    if (ls.lastIndexOf(x) > -1) {
                        start = ls.lastIndexOf(x);
                    }
                    break;
                case "SEARCH-BACKWARD":
                    String rs = content.substring(start);
                    if (rs.indexOf(x) > -1) {
                        start += rs.indexOf(x);
                    }
                    break;
                case "INSERT":
                    String ls1 = content.substring(0, start);
                    String rs1 = content.substring(start);
                    content = ls1 + x + rs1;
                    start = content.length();
                    break;
                case "REPLACE":
                    String ls2 = content.substring(0, start);
                    content = ls2 + x;
                    break;
                case "DELETE":
                    if (start + Integer.parseInt(x) > content.length()) {
                        content = content.substring(0, start);
                    } else {
                        content = content.substring(0, start) + content.substring(start + Integer.parseInt(x));
                    }
                    break;
            }
        }
        System.out.println(content);
    }

    /**
     * 44 阿里巴巴找黄金宝箱(II)
     */
    public static void alibbzhaobaoxiang2() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < lines.length; i++) {
            map.put(lines[i], map.getOrDefault(lines[i], 0) + 1);
        }
        int mid = lines.length / 2;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        int n = 0, sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getValue();
            n++;
            if (sum >= mid) {
                break;
            }
        }
        System.out.println(n);
    }

    /**
     * 43 阿里巴巴找黄金宝箱(III)
     */
    public static void alibbzhaobaoxiang3() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        boolean flag = false;
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            int l = lines[i];
            for (int j = i + 1; j < k + i + 1 && j < lines.length; j++) {
                if (l == lines[j]) {
                    flag = true;
                    index = i;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(index);
    }

    /**
     * 42 需要打开多少监控器
     */
    public static void jianshiqi() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] ins = new int[lines[0]][lines[1]];
        for (int i = 0; i < lines[0]; i++) {
            ins[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int count = 0;
        for (int i = 0; i < ins.length; i++) {
            for (int j = 0; j < ins[0].length; j++) {
                if (ins[i][j] == 1) {
                    count++;
                } else if (j > 0 && ins[i][j - 1] == 1) {
                    count++;
                } else if (j < lines[1] - 1 && ins[i][j + 1] == 1) {
                    count++;
                } else if (i > 0 && ins[i - 1][j] == 1) {
                    count++;
                } else if (i < lines[0] - 1 && ins[i + 1][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void redianwangzhantongji() {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.equals("")) continue;
            if (!line.contains(".")) {//输入数字
                int n = Integer.parseInt(line);
                if (n > map.size()) {
                    break;
                }
                List<String> list = map.entrySet().stream().sorted((a, b) -> {
                    if (b.getValue() == a.getValue()) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return b.getValue() - a.getValue();
                }).map(s -> s.getKey()).limit(n).collect(Collectors.toList());
                System.out.println(String.join(",", list));
            } else {
                map.put(line, map.getOrDefault(line, 0) + 1);
            }
        }
    }

    /**
     * 40 流水线
     */
    public static void liushuixian() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] renwu = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ints = Arrays.stream(renwu).sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            if (i < lines[0]) {
                map.put(i, ints[i]);
            } else {
                Map.Entry<Integer, Integer> entry = map.entrySet().stream().min((a, b) -> a.getValue() - b.getValue()).get();
                map.put(entry.getKey(), entry.getValue() + ints[i]);
            }
        }
        Map.Entry<Integer, Integer> entry = map.entrySet().stream().max((a, b) -> a.getValue() - b.getValue()).get();
        System.out.println(entry.getValue());
    }

    /**
     * 39 矩形相交的面积
     */
    public static void juxingxiangjiaomianji() {
        Scanner sc = new Scanner(System.in);
        int[] lines1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lines2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lines3 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lx = 0, rx = 0;
        int uy = 0, dy = 0;
        lx = Math.max(Math.max(lines1[0], lines2[0]), lines3[0]);
        rx = Math.min(Math.min(lines1[0] + lines1[2], lines2[0] + lines2[2]), lines3[0] + lines3[2]);
        uy = Math.min(Math.min(lines1[1], lines2[1]), lines3[1]);
        dy = Math.max(Math.max(lines1[1] - lines1[3], lines2[1] - lines2[3]), lines3[1] - lines3[3]);
        if (lx >= rx || dy >= uy) {
            System.out.println(0);
            return;
        }
        int ji = (rx - lx) * (uy - dy);
        System.out.println(ji);
    }

    /**
     * 38 相对开音节
     */
    public static void xiangduikaiyinjie() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        int count = 0;
        for (int i = 0; i < lines.length; i++) {
            String s = lines[i];
            String rev = stringReverse(s);
            for (int j = 0; j < rev.length() - 3; j++) {
                String temp = rev.substring(j, j + 4);
                if (isKaiYinJie(temp)) {
                    count++;
                }
            }

        }
        System.out.println(count);
    }

    public static boolean isKaiYinJie(String s) {
        String fuyin = "bcdfghjklmnpqrstvwxyz";
        String yuanyin = "aeiou";
        if (fuyin.contains(s.charAt(0) + "") && fuyin.contains(s.charAt(2) + "") && yuanyin.contains(s.charAt(1) + "") && "e".equals(s.charAt(3) + "") && !"r".equals(s.charAt(2) + "")) {
            return true;
        }
        return false;
    }

    public static String stringReverse(String s) {
        char[] chr = s.toCharArray();
        String res = "";
        for (int i = chr.length - 1; i >= 0; i--) {
            if (chr[i] >= 'a' && chr[i] <= 'z' || chr[i] >= 'A' && chr[i] <= 'Z') {
                res += chr[i];
            } else {
                return s;
            }
        }
        return res;
    }

    /**
     * 37 数组拼接
     */
    public static void shuzupinjie() {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int anum = sc.nextInt();
        sc.nextLine();
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < anum; i++) {
            int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            list.add(lines);
            sum += lines.length;
        }
        List<Integer> res = new ArrayList<Integer>();
        int index = 0;
        while (res.size() < sum) {
            for (int i = 0; i < anum; i++) {
                int[] lines = list.get(i);
                for (int j = index; j < len + index && lines.length > j; j++) {
                    res.add(lines[j]);
                }
            }
            index += len;
        }
        System.out.println(String.join(",", res.stream().map(String::valueOf).collect(Collectors.joining(","))));
    }

    /**
     * 36 乱序整数序列两数之和绝对值最小
     */
    public static void liangshuzhihejueduizhi() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 0; i < lines.length - 1; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                if (sum > Math.abs(lines[i] + lines[j])) {
                    a = lines[i];
                    b = lines[j];
                    sum = Math.abs(lines[i] + lines[j]);
                }
            }
        }
        if (a > b) {
            int temp = 0;
            temp = a;
            a = b;
            b = temp;
        }
        System.out.println(a + " " + b + " " + sum);
    }

    /**
     * 35 判断一组不等式是否满足约束并输出最大差
     */
    public static void panduanbudengshi() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(";");
        String[] yueshu = lines[lines.length - 1].split(",");
        double[] mubiao = Arrays.stream(lines[lines.length - 2].split(",")).mapToDouble(Double::parseDouble).toArray();
        int[] bianliang = Arrays.stream(lines[lines.length - 3].split(",")).mapToInt(Integer::parseInt).toArray();
        double[][] xishu = new double[yueshu.length][bianliang.length];
        double max = Double.MIN_VALUE;
        boolean isRight = true;
        for (int i = 0; i < yueshu.length; i++) {
            xishu[i] = Arrays.stream(lines[i].split(",")).mapToDouble(Double::parseDouble).toArray();
            double sum = 0;
            for (int j = 0; j < bianliang.length; j++) {
                sum += bianliang[j] * xishu[i][j];
            }
            max = Math.max(max, sum - mubiao[i]);
            if (yueshu[i].equals(">")) {
                if (sum <= mubiao[i]) {
                    isRight = false;
                }
            } else if (yueshu[i].equals(">=")) {
                if (sum < mubiao[i]) {
                    isRight = false;
                }
            } else if (yueshu[i].equals("<=")) {
                if (sum > mubiao[i]) {
                    isRight = false;
                }
            } else if (yueshu[i].equals("<")) {
                if (sum >= mubiao[i]) {
                    isRight = false;
                }
            } else if (yueshu[i].equals("=")) {
                if (sum != mubiao[i]) {
                    isRight = false;
                }
            }
        }
        System.out.println(isRight + " " + (int) Math.floor(max));
    }

    /**
     * 34 磁盘容量排序
     */
    public static void cipanpaixu() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<String[]> list = new ArrayList<String[]>();
        for (int i = 0; i < num; i++) {
            String[] lines = new String[2];
            lines[0] = sc.nextLine();
            lines[1] = rongliangzhuanshuzi(lines[0]) + "";
            list.add(lines);
        }
        list.sort((a, b) -> {
            if (a[1] == b[1]) {
                return -1;
            }
            return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
        });
        list.forEach(line -> System.out.println(line[0]));
    }

    public static int rongliangzhuanshuzi(String s) {
        int num = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                num += Integer.valueOf(temp);
                temp = "";
            } else if (c == 'G') {
                num += Integer.valueOf(temp) * 1024;
                temp = "";
            } else if (c == 'T') {
                num += Integer.valueOf(temp) * 1024 * 1024;
                temp = "";
            } else {
                temp += c;
            }
        }
        return num;
    }

    /**
     * 33 根据某条件聚类最少交换次数
     */
    public static void zuishaojiaohuan() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int num = Arrays.stream(lines).filter(s -> s < k).toArray().length;
        for (int i = 0; i < lines.length - num + 1; i++) {
            int count = 0;
            for (int j = i; j < num + i; j++) {
                if (lines[j] >= k) {
                    count++;
                }
            }
            min = Math.min(min, count);
        }
        System.out.println(min);
    }

    /**
     * 32 最长公共后缀
     */
    public static void zuichanghouzhui() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().replace("[\"", "").replace("\"]", "").split("\",\"");
        String res = "@Zero";
        String temp = "";
        boolean error = false;
        List<String> strs = Arrays.stream(lines).sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
        for (int i = 1; i < strs.get(0).length() + 1; i++) {
            temp = strs.get(0).substring(strs.get(0).length() - i);
            for (int j = 1; j < strs.size(); j++) {
                String sj = strs.get(j).substring(strs.get(j).length() - i);
                if (!temp.equals(sj)) {
                    error = true;
                    break;
                }
            }
            if (error) {
                break;
            }
            res = temp;
        }
        System.out.println(res);
    }


    /**
     * 31 模拟消息队列
     */
    public static void xiaoxiduilie() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] consumers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < lines.length; i += 2) {
            Message message = new Message(lines[i], lines[i + 1]);
            list.add(message);
        }
        Collections.sort(list);
        List<int[]> cons = new ArrayList<int[]>();
        for (int i = 0; i < consumers.length; i += 2) {
            int[] con = new int[]{consumers[i], consumers[i + 1]};
            cons.add(con);
        }
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (int i = 0; i < list.size(); i++) {
            int time = list.get(i).time;
            int message = list.get(i).message;
            int index = -1;
            for (int j = 0; j < cons.size(); j++) {
                int start = cons.get(j)[0];
                int end = cons.get(j)[1];
                if (time > start && time < end) {
                    index = j;
                }
                if (time == start) {
                    index = j;
                    break;
                }
            }
            if (index == -1) continue;
            if (map.get(index) == null) {
                List<String> l = new ArrayList<String>();
                l.add(message + "");
                map.put(index, l);
            } else {
                map.get(index).add(message + "");
            }
        }
        for (int i = 0; i < cons.size(); i++) {
            if (map.get(i) == null) {
                System.out.println(-1);
            } else {
                System.out.println(String.join(" ", map.get(i)));
            }
        }
    }

    static class Message implements Comparable<Message> {
        int time;
        int message;

        public Message(int time, int message) {
            this.time = time;
            this.message = message;
        }


        @Override
        public int compareTo(@NotNull Message o) {
            return this.time - o.time;
        }
    }

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
