package com.example.demo.Algorithm;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

//https://blog.csdn.net/qq_34465338/article/details/130719693
public class HwOD2023B {

    public static void main(String[] args) {
        while (true) {
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
//            ipzhuanhuan();
//            stringDigest();
//            xiangyingbaowen();
//            shijiantuisong();
//            shuliemiaoshu();
//            zuixiaoshuzi();
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
//            duoshuzhihe();
//            shuzifanzhuandayin();
//            shudayan();
//            jisuanzuidachengji();
//            zuichanglianxuzixulie();
//            juzhenxishusaomiao();
//            juzhenzuidazhi();
//            youxianjiduilie();
//            aimianbanshibie();
//            huifushuzixulie();
//            gougushuyuanzu();
//            stringzixulie();
//            jisuanzuijiejindeshu();
//            wanquanerchashu();
//            zifuchaunfenge();
//            zhengfangxingshuliang();
//            chengzuobaomidianti();
//            bahebisai();
//            juzhenyuansubianjiezhi();
//            shengruliwu();
//            wenjianmuludaxiao();
//            shuzupaixu();
//            tiaofangzi1();
//            neicunziyuanfenpei();
//            zengqiangdeStrStr();
//            yijuxingqiugaizao();
//            zhaozuixiaoshu();
//            fuwuguzhang();
//            jieyabaowen();
//            stringCompare();
//            zhaodanci();
//            qujianjiaoji();
//            shujidiefang();
//            weareateam();
//            zuidajiazhikuangdui();
//            shujuzuijieyuebeifen();
//            zuichangguangbo();
//            chazidian();
//            shuziyouxi();
//            lanqiubisai();
//            tiaogezi2();
//            zhaopin();
//            zuixiaochuanshushiyan();
//            caimima();
//            tiaofangzi2();
//            zhaoshuzi();
//            pinglunzhuanhuanshuchu();
//            zuijiazhungshujuli();
//            guankanwenyihuiyanwenti();
//            tiaogeziyouxi();
//            fenjimu();
//            tiaogezi1();
//            caiyangguolv();
//            renqizuigaodianpu();
//            shuzhuangjiegou();
//            zifupipei();
            shuzixuliebidaxiao();
//            erweisan();
//            erchashubianli();
//            alibabazhaohuangjinbaoxiangIV();
//            melondenanti();
//            jisuanwumalv();
//            diejimu();
//            zuichanglianxufangboxinhao();
        }
    }


    //int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//    List<Integer> lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());


////////////////////////////////中阶/////////////////////////////////////////

    /**
     * 39	最长方连续方波信号
     */
    public static void zuichanglianxufangboxinhao() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String res = "";    //最终方波
        String temp = "";   //方波容器
        boolean b = false;  //符合方波信号
        boolean isFomat = true; //符合完全连续方波信号
        if (s.charAt(0) == '0') {       //如果第一个为0，则从第一个开始识别
            temp = "0";
            b = true;
        }

        for (int i = 1; i < s.length(); i++) {
            if (b) {      //识别中
                if (s.charAt(i) == s.charAt(i - 1)) {     //此时的数等于前一个数
                    if (s.charAt(i) == '0') {       //出现重复的0则出局
                        if (temp.length() >= 3 && isFomat) {        //如果都是0，且符合规则（不含连续1大于3个长度）
                            res = temp.length() > res.length() ? temp : res;      //取最长信号
                        }
                        temp = "0";     //容器重置
                        isFomat = true;
                    } else {
                        temp += s.charAt(i);      //出现重复的1继续，不过已不符合要求（不含连续的1）
                        isFomat = false;
                    }
                } else {
                    temp += s.charAt(i);      //无重复的值则继续
                    if (i == s.length() - 1 && s.charAt(i) == '0' && isFomat) { //最后一个是0且符合连续交互
                        res = temp.length() > res.length() ? temp : res;      //取最长信号
                    }
                }
            } else {
                if (s.charAt(i) == '0') {   //遇到0就开始识别
                    temp = "0";
                    b = true;
                }
            }
        }
        System.out.println(res.length() == 0 ? -1 : res);
    }

    /**
     * 38	【满分】叠积木
     */
    public static void diejimu() {
        Scanner sc = new Scanner(System.in);
        List<Integer> lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int sum = lines.stream().reduce(Integer::sum).get();
        Collections.sort(lines, (a, b) -> b - a);
        int chang = lines.get(0);
        int chenggong = -1;
        List<Integer> list = new ArrayList<Integer>();
        copyList(lines, list);
        int index = 0;
        if (sum % chang == 0) {
            chenggong = isQiang(list, chang, index);
        }
        if (chenggong == -1) {
            chang = lines.get(0) + lines.get(lines.size() - 1);
            list = new ArrayList<Integer>();
            copyList(lines, list);
            if (sum % chang == 0) {
                chenggong = isQiang(list, chang, index);
            }
        }
        System.out.println(chenggong);
    }

    public static int isQiang(List<Integer> list, int chang, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == chang) {
                list.remove(i);
                index++;
                i--;
                continue;
            }
            if (list.size() >= 2 && list.get(i) + list.get(list.size() - 1) == chang) {
                list.remove(i);
                list.remove(list.size() - 1);
                index++;
                i--;
            } else {
                return -1;
            }
        }
        return index;
    }

    public static void copyList(List<Integer> lines, List<Integer> list) {
        for (int i = 0; i < lines.size(); i++) {
            list.add(lines.get(i));
        }
    }

    /**
     * 37	【满分】计算误码率
     */
    public static void jisuanwumalv() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String a1 = "";
        String b1 = "";
        String ints = "";
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (Character.isDigit(c)) {
                ints += c;
            } else if (Character.isLetter(c)) {
                int n = Integer.parseInt(ints);
                for (int j = 0; j < n; j++) {
                    a1 += c;
                }
                ints = "";
            }
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (Character.isDigit(c)) {
                ints += c;
            } else if (Character.isLetter(c)) {
                int n = Integer.parseInt(ints);
                for (int j = 0; j < n; j++) {
                    b1 += c;
                }
                ints = "";
            }
        }
        int num = 0;
        for (int i = 0; i < a1.length(); i++) {
            char ca = a1.charAt(i);
            char cb = b1.charAt(i);
            if (ca != cb) {
                num++;
            }
        }
        System.out.println(num + "/" + a1.length());
    }

    /**
     * 36	MELON的难题
     */
    public static void melondenanti() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Integer> lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Collections.sort(lines, (a, b) -> b - a);
        int sum = lines.stream().reduce(Integer::sum).get();
        int mid = sum / 2;
        if (mid * 2 != sum) {
            System.out.println(-1);
            return;
        }
        yuhuashi = Integer.MAX_VALUE;
        melondenantiBack(lines, 0, 0, new ArrayList<Integer>(), mid);
        System.out.println(yuhuashi);
    }

    static int yuhuashi = Integer.MAX_VALUE;

    public static void melondenantiBack(List<Integer> lines, int index, int sum, List<Integer> temp, int mid) {
        if (index >= lines.size() || sum == mid) {
            if (sum == mid) {
                yuhuashi = Math.min(yuhuashi, temp.size());
            }
        } else {
            for (int i = index; i < lines.size(); i++) {
                temp.add(lines.get(i));
                sum += lines.get(i);
                melondenantiBack(lines, ++index, sum, temp, mid);
                temp.remove(lines.get(i));
                sum -= lines.get(i);
            }
        }
    }

    /**
     * 35	阿里巴巴找黄金宝箱(IV)
     */
    public static void alibabazhaohuangjinbaoxiangIV() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] ints = new int[lines.length * 2];
        System.arraycopy(lines, 0, ints, 0, lines.length);
        System.arraycopy(lines, 0, ints, lines.length, lines.length);
        int[] res = new int[lines.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < lines.length; i++) {
            int x = lines[i];
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] > x) {
                    res[i] = ints[j];
                    break;
                }
            }
        }
        String s = "";
        for (int i = 0; i < res.length; i++) {
            s += res[i] + ",";
        }
        System.out.println(s.substring(0, s.length() - 1));
    }

    /**
     * 34	二叉树遍历
     */
    public static void erchashubianli() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Deque<TreeNode1> deque = new ArrayDeque<>();
        TreeNode1 root = new TreeNode1(line.charAt(0) + "");
        deque.push(root);
        TreeNode1 parent = root;
        String status = "";
        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '{') {
                status = "l";
                parent = deque.peek();
                continue;
            }
            if (c == '}') {
                deque.pop();
                parent = deque.peek();
                continue;
            }
            if (c == ',') {
                status = "r";
                continue;
            }
            if (Character.isLetter(c)) {
                TreeNode1 cur = new TreeNode1(c + "");
                if (status.equals("l")) {
                    parent.left = cur;
                } else {
                    parent.right = cur;
                }
                if (line.charAt(i + 1) == '{') {
                    deque.push(cur);
                }
            }
        }
        String res = "";
        TreeNode1 node = root;
        Deque<TreeNode1> tree = new ArrayDeque<>();
        tree.push(node);
        while (!tree.isEmpty()) {
            while (node.left != null || node.right != null) {
                if (node.left != null) {
                    node = node.left;
                    tree.push(node);
//                    }
                } else {
                    res += node.val;
                    tree.pop();
                    node = node.right;
                    tree.push(node);
                }
            }
            res += node.val;
            node = tree.pop();
            while (node.right == null && !tree.isEmpty()) {
                node = tree.pop();
                res += node.val;
            }
            if (node.right != null) {
                node = node.right;
                tree.push(node);
            }
        }

        System.out.println(res);
    }

    static class TreeNode1 {

        String val;
        TreeNode1 left;
        TreeNode1 right;


        public TreeNode1(String val) {
            this.val = val;
        }

        public TreeNode1() {
        }
    }

    /**
     * 33	二维伞的雨滴效应
     */
    public static void erweisan() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = new TreeNode(lines[0]);
        TreeNode gfNode = new TreeNode(-1);//最近的左子树为空的节点
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        boolean isTree = true;
        for (int i = 1; i < lines.length; i++) {
            TreeNode node = deque.peek();
            TreeNode cur = new TreeNode(lines[i]);
            while (!deque.isEmpty() && deque.peek().val < cur.val) {
                node = deque.pop();
                gfNode = node;
            }
            if (node.val > cur.val) {
                if (gfNode.val > cur.val) {
                    isTree = false;
                    break;
                }
                node.left = cur;
            } else {
                node.right = cur;
            }
            deque.push(cur);
        }
        if (isTree) {
            int left = 0;
            int right = 0;
            TreeNode node = root;
            if (node.left != null) {
                while (node.left != null || node.right != null) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                }
                left = node.val;
            }
            node = root;
            if (node.right != null) {
                while (node.left != null || node.right != null) {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node = node.left;
                    }
                }
                right = node.val;
            }

            System.out.println("1 " + left + " " + right);
        } else {
            System.out.println("0 0 0");
        }

    }


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;


        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }

    /**
     * 32	数字序列比大小
     */
    public static void shuzixuliebidaxiao() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] stringA = sc.nextLine().split(" ");
        String[] stringB = sc.nextLine().split(" ");

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < stringA.length; i++) {
            listA.add(Integer.valueOf(stringA[i]));
            listB.add(Integer.valueOf(stringB[i]));
        }

        Collections.sort(listA);
        Collections.sort(listB);
        int res = 0;
        while (listA.size() > 0) {
            if (listA.get(listA.size() - 1) > listB.get(listB.size() - 1)) {
                res++;
                listA.remove(listA.size() - 1);
                listB.remove(listB.size() - 1);
            } else if (listA.get(listA.size() - 1) < listB.get(listB.size() - 1)) {
                res--;
                listA.remove(0);
                listB.remove(listB.size() - 1);
            } else {
                if (listA.get(0) > listB.get(0)) {
                    res++;
                    listA.remove(0);
                    listB.remove(0);
                } else {
                    if (listA.get(0) < listB.get(listB.size() - 1))
                        res--;
                    listA.remove(0);
                    listB.remove(listB.size() - 1);
                }
            }
        }

        System.out.println(res);
    }

    /**
     * 31	字符匹配
     */
    public static void zifupipei() {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String match = sc.nextLine();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (stringMatch(s[i], match, 0, 0)) {
                list.add(i + "");
            }
        }
        if (list.size() == 0) {
            System.out.println("");
        } else {
            System.out.println(String.join(",", list));
        }
    }

    public static boolean stringMatch(String s, String match, int si, int mi) {
        for (int i = si, j = mi; i < s.length() && j < match.length(); i++, j++) {
            char c = s.charAt(i);
            char m = match.charAt(j);
            if (Character.isLowerCase(m) && c != m) {
                return false;
            } else if (m == '*') {
                if (j == match.length() - 1) {
                    return true;
                }
                boolean result = false;
                for (int k = i; k < s.length(); k++) {
                    if ((match.charAt(j + 1) == '*' || match.charAt(j + 1) == '.' || match.charAt(j + 1) == s.charAt(k)) && stringMatch(s, match, k, j + 1)) {
                        result = true;
                        break;
                    }
                }
                return result;
            }
            if (i != s.length() - 1 && j == match.length() - 1) {
                return false;
            }
            if (i == s.length() - 1) {
                for (int k = j + 1; k < match.length(); k++) {
                    if (match.charAt(k) != '*') {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 30	树状结构查询
     */
    public static void shuzhuangjiegou() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<String[]> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String[] s = sc.nextLine().split(" ");
            list.add(s);
            List<String> list1 = map.get(s[1]);
            if (list1 != null) {
                list1.add(s[0]);
            } else {
                list1 = new ArrayList<>();
                list1.add(s[0]);
            }
            map.put(s[1], list1);
        }
        String c = sc.nextLine();
        List<String> list2 = new ArrayList<>();
        shujiegouBack(map, c, list2);
        Collections.sort(list2);
        list2.forEach(System.out::println);
    }

    public static void shujiegouBack(Map<String, List<String>> map, String c, List<String> list) {
        List<String> list1 = map.get(c);
        if (list1 != null) {
            list.addAll(new ArrayList<>(list1));
            for (int i = 0; i < list1.size(); i++) {
                shujiegouBack(map, list1.get(i), list);
            }
        }
    }

    /**
     * 29	人气最高的店铺
     */
    public static void renqizuigaodianpu() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = lines[0];
        int m = lines[1];
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            list.add(temp);
        }
        butie = Integer.MAX_VALUE;
        dianpulapiao(list, 0, new ArrayList<>());
        System.out.println(butie);
    }

    static int butie = Integer.MAX_VALUE;

    public static void dianpulapiao(List<int[]> list, int index, List<int[]> temp) {
        if (index == list.size() || isMost(list, temp)) {
            if (isMost(list, temp)) {
                int sum = temp.stream().map(a -> a[1]).mapToInt(Integer::valueOf).sum();
                butie = Math.min(butie, sum);
            }
        } else {
            for (int i = index; i < list.size(); i++) {
                temp.add(list.get(i));
                dianpulapiao(list, ++index, temp);
                temp.remove(list.get(i));
            }
        }
    }

    public static boolean isMost(List<int[]> list, List<int[]> temp) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (!temp.contains(list.get(i))) {
                map.put(list.get(i)[0], map.getOrDefault(list.get(i)[0], 0) + 1);
            } else {
                map.put(1, map.getOrDefault(1, 0) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((a, b) -> {
            if (b.getValue() == a.getValue()) {
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        }).collect(Collectors.toList());
        if (collect.get(0).getKey() == 1) {
            return true;
        }
        return false;
    }

    /**
     * 28	采样过滤
     */
    public static void caiyangguolv() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int t = sc.nextInt();
        int p = sc.nextInt();
        sc.nextLine();
        int[] S = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        List<Integer> errors = new ArrayList<Integer>();
        boolean guzhang = false;
        int huifu = 0;
        for (int i = 0, l = Integer.MAX_VALUE; i < S.length; i++) {
            if (i == S.length - 1 && !guzhang) {
                count = Math.max(count, i - l + 1);
            }
            if (l == Integer.MAX_VALUE && !guzhang) {
                if (S[i] >= 0) {
                    l = i;
                }
                continue;
            }
            if (S[i] <= 0 || S[i] < S[i - 1] || S[i] - S[i - 1] >= 10) {
                errors.add(i);
                S[i] = S[i - 1];
                huifu = 0;
            } else {
                if (guzhang) {
                    huifu++;
                    if (huifu == p) {
                        guzhang = false;
                        huifu = 0;
                        l = i;
                    }
                }
            }
            if (errors.size() >= t) {
                if (i - errors.get(0) + 1 <= m) {
                    count = Math.max(count, errors.get(t - 1) - l);
                    l = Integer.MAX_VALUE;
                    guzhang = true;
                }
                errors.remove(0);
            }
        }
        System.out.println(count);
    }

    /**
     * 27	跳格子
     */
    public static void tiaogezi1() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] res = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            if (i == 0) {
                res[i] = lines[i];
                continue;
            }
            if (i == 1) {
                res[i] = Math.max(lines[i], res[i - 1]);
                continue;
            }
            res[i] = Math.max(lines[i] + res[i - 2], res[i - 1]);
        }
        System.out.println(res[res.length - 1]);
    }

    /**
     * 26	分积木
     */
    public static void fenjimu() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int first = lines[0];
        for (int i = 1; i < lines.length; i++) {
            first = first ^ lines[i];
        }
        if (first == 0) {
            System.out.println(Arrays.stream(lines).sum() - Arrays.stream(lines).min().getAsInt());
        } else {
            System.out.println("NO");
        }
    }

    /**
     * 25	跳格子游戏
     */
    public static void tiaogeziyouxi() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<int[]> list = new ArrayList<int[]>();
        while (!sc.hasNext("s")) {
            int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(lines);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            boolean kaiqi = true;
            for (int j = 0; j < list.size(); j++) {
                int[] temp = list.get(j);
                if (temp[1] == i) {
                    kaiqi = false;
                }
            }
            if (kaiqi) {
                set.add(i);
            }
        }
        boolean found = true;
        while (found) {
            found = false;
            int number = set.size();
            for (int j = 0; j < list.size(); j++) {
                int[] temp = list.get(j);
                if (set.contains(temp[0])) {
                    set.add(temp[1]);
                }
            }
            if (set.size() == num) {
                System.out.println("yes");
                return;
            }
            if (set.size() > number) {
                found = true;
            }
        }
        System.out.println("no");
    }

    /**
     * 24	观看文艺汇演问题
     */
    public static void guankanwenyihuiyanwenti() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lines[1] += lines[0];
            list.add(lines);
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] res = new int[list.size()];
        res[0] = 1;
        int end = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            int left = list.get(i)[0];
            if (end + 15 <= left) {
                res[i] = res[i - 1] + 1;
                end = left;
            } else {
                res[i] = res[i - 1];
                end = Math.min(end, left);
            }
        }
        System.out.println(res[num - 1]);
    }

    /**
     * 23	【满分】最佳植树距离
     */
    public static void zuijiazhungshujuli() {
        Scanner sc = new Scanner(System.in);
//        7
//        1 5 3 6 10 8 13
//        3
        int len = sc.nextInt();
        sc.nextLine();
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(lines);
        int num = sc.nextInt();
        int left = 1;
        int answer = 0;
        int right = lines[len - 1] - lines[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int pre = lines[0];
            for (int i = 1; i < len; i++) {
                if (lines[i] - pre >= mid) {//超过前一棵树的间距在种下一颗
                    count++;
                    if (count == num) {
                        answer = mid;
                        left = mid + 1;
                        break;
                    }
                    pre = lines[i];
                }
            }
            if (count < num) {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    /**
     * 22	评论转换输出
     */
    public static void pinglunzhuanhuanshuchu() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(",");
        List<Content> list = new ArrayList<Content>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < lines.length; i += 2) {
            String con = lines[i];
            int num = Integer.parseInt(lines[i + 1]);
            int row = 1;
            if (list.size() > 0) {  //如果list不为空，则最后一个就是他的父级
                Content last = list.get(list.size() - 1);
                row = last.row + 1;
                last.num--;
                if (last.num == 0) {
                    list.remove(last);
                }
            }

            if (num > 0) {  //只需要加入有子集的对象
                Content content = new Content();
                content.row = row;
                content.cont = con;
                content.num = num;
                list.add(content);
            }

            map.put(row, map.getOrDefault(row, "") + con + " ");
        }
        System.out.println(map.size());
        map.forEach((a, b) -> {
            System.out.println(b);
        });
    }

    static class Content {
        int row;
        String cont;
        int num;
    }

    /**
     * 21	找出两个整数数组中同时出现的
     */
    public static void zhaoshuzi() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] lines2 = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> res = new HashMap<>();
        for (int i : lines) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : lines2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (map2.containsKey(key)) {
                res.put(key, Math.min(entry.getValue(), map2.get(key)));
            }
        }
        if (res.isEmpty()) {
            System.out.println("NULL");
            return;
        }
        List<Map.Entry<Integer, Integer>> list = res.entrySet().stream().sorted((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey() - b.getKey();
            }
            return a.getValue() - b.getValue();
        }).collect(Collectors.toList());
        int v = 0;
        String s = "";
        for (Map.Entry<Integer, Integer> entry : list) {
            if (v == 0) {
                v = entry.getValue();
                s = v + ":" + entry.getKey();
                continue;
            }
            if (entry.getValue() != v) {
                System.out.println(s);
                v = entry.getValue();
                s = v + ":" + entry.getKey();
            } else {
                s += "," + entry.getKey();
            }
        }
        System.out.println(s);
    }

    /**
     * 20	跳房子II
     */
    public static void tiaofangzi2() {
        Scanner sc = new Scanner(System.in);
        List<Integer> lines = Arrays.stream(sc.nextLine().replace("[", "").replace("]", "").split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int n = sc.nextInt();
        List<Integer> result = new ArrayList<Integer>();
        tiaofangzi2IndexSum = Integer.MAX_VALUE;
        tiaofangzi2Back(lines, 0, 0, new ArrayList<>(), result, n);
        System.out.println(result.toString());
    }

    static int tiaofangzi2IndexSum = Integer.MAX_VALUE;

    public static void tiaofangzi2Back(List<Integer> lines, int index, int iSum, List<Integer> values, List<Integer> res, int n) {
        if (index >= lines.size() || values.size() == 3) {
            if (values.size() == 3) {
                int sum = values.stream().reduce(Integer::sum).get();
                if (sum == n) {
                    if (iSum < tiaofangzi2IndexSum) {
                        for (int i = 0; i < values.size(); i++) {
                            res.add(values.get(i));
                        }
                        tiaofangzi2IndexSum = iSum;
                    }
                }
            }
        } else {
            for (int i = index; i < lines.size(); i++) {
                values.add(lines.get(i));
                iSum += i;
                tiaofangzi2Back(lines, ++index, iSum, values, res, n);
                values.remove(lines.get(i));
                iSum -= i;
            }
        }

    }

    /**
     * 19	猜密码
     */
    public static void caimima() {
        Scanner sc = new Scanner(System.in);
        List<Integer> lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int n = sc.nextInt();
        Collections.sort(lines);
        List<String> res = new ArrayList<String>();
        caimimaBackTracking(lines, 0, res, new ArrayList<String>(), n);
        Collections.sort(res);
        res.forEach(System.out::println);
    }

    public static void caimimaBackTracking(List<Integer> lines, int index, List<String> res, List<String> temp, int len) {
        if (index == lines.size()) {
            if (temp.size() >= len) {
                res.add(String.join(",", temp));
            }
        } else {
            if (temp.size() >= len) {
                res.add(String.join(",", temp));
            }
            for (int i = index; i < lines.size(); i++) {
                temp.add(lines.get(i) + "");
                caimimaBackTracking(lines, ++index, res, temp, len);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * 18	最小传输时延
     */
    public static void zuixiaochuanshushiyan() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        List<int[]> lines = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            lines.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }
        int fs = sc.nextInt();
        int end = sc.nextInt();
        int count = 0;
        List<Integer> res = new ArrayList<>();
        guangboBack(lines, count, res, fs, end);
        int min = res.stream().reduce(Integer::min).get();
        System.out.println(min);
    }


    public static void guangboBack(List<int[]> lines, int count, List<Integer> res, int fs, int end) {
        if (fs == end) {
            res.add(count);
        } else {
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i)[0] == fs) {
                    count += lines.get(i)[2];
                    guangboBack(lines, count, res, lines.get(i)[1], end);
                    count -= lines.get(i)[2];
                }
            }
        }
    }

    /**
     * 17	招聘
     */
    public static void zhaopin() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        List<int[]> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lines.add(new int[]{sc.nextInt(), sc.nextInt()});
        }
        List<List<int[]>> list = new ArrayList<>();
        Collections.sort(lines, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {
            int start = lines.get(i)[0];
            boolean found = false;
            for (List<int[]> msg : list) {
                if (msg.size() == m) {
                    continue;
                }
                if (msg.get(msg.size() - 1)[1] <= start) {
                    msg.add(lines.get(i));
                    found = true;
                    break;
                }
            }
            if (!found) {
                List<int[]> temp = new ArrayList<int[]>();
                temp.add(lines.get((i)));
                list.add(temp);
            }
        }
        System.out.println(list.size());
    }

    /**
     * 16	跳格子2  动态规划
     */
    public static void tiaogezi2() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lines1 = new int[lines.length - 1];
        int[] lines2 = new int[lines.length - 1];
        System.arraycopy(lines, 0, lines1, 0, lines.length - 1);
        System.arraycopy(lines, 1, lines2, 0, lines.length - 1);
        System.out.println(Math.max(tiaogezi2Handler(lines1), tiaogezi2Handler(lines2)));
    }

    public static int tiaogezi2Handler(int[] lines) {
        int[] dp = new int[lines.length];
        dp[0] = lines[0];
        for (int i = 1; i < lines.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(dp[0], lines[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], lines[i] + dp[i - 2]);
            }
        }
        return dp[lines.length - 1];
    }

    /**
     * 15	【满分】篮球比赛
     */
    public static void lanqiubisai() {
        Scanner sc = new Scanner(System.in);
        List<Integer> lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int sum = lines.stream().reduce(Integer::sum).get();
        zuixiaozhanlicha = Integer.MAX_VALUE;
        lanqiubisaiBack(lines, new ArrayList<>(), 0, sum);
        System.out.println(zuixiaozhanlicha);
    }

    static int zuixiaozhanlicha = Integer.MAX_VALUE;

    public static void lanqiubisaiBack(List<Integer> list, List<Integer> temp, int index, int sum) {
        if (index >= list.size() || temp.size() == 5) {
            if (temp.size() == 5) {
                int tempSum = temp.stream().reduce(Integer::sum).get();
                if (Math.abs(tempSum * 2 - sum) < zuixiaozhanlicha) {
                    zuixiaozhanlicha = Math.abs(tempSum * 2 - sum);
                }
            }
        } else {
            for (int i = index; i < list.size(); i++) {
                temp.add(list.get(i));
                lanqiubisaiBack(list, temp, ++index, sum);
                temp.remove(list.get(i));
            }
        }
    }

    /**
     * 14	【满分】数字游戏
     */
    public static void shuziyouxi() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            boolean found = false;
            int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < n; j++) {
                    sum += lines[j];
                    if (sum % m == 0) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    System.out.println(1);
                    break;
                }
            }
            if (!found) {
                System.out.println(0);
            }
        }
    }

    /**
     * 13	【满分】查字典
     */
    public static void chazidian() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        String f = lines[0];
        boolean found = false;
        for (int i = 2; i < lines.length; i++) {
            if (lines[i].indexOf(f) == 0) {
                found = true;
                System.out.println(lines[i]);
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }

    /**
     * 12	最长广播响应
     */
    public static void zuichangguangbo() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> temp = new HashSet<Integer>();
        sc.nextLine();
        List<List<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> line = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            lines.add(line);
        }
        int first = sc.nextInt();
        int count = 0;
        set.add(first);
        temp.add(first);
        while (true) {
            set.forEach(a -> {
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).contains(a)) {
                        temp.addAll(lines.get(i));
                    }
                }
            });
            count++;
            if (temp.size() == n) {
                break;
            }
            set.addAll(temp);
        }
        System.out.println(count * 2);
    }

    /**
     * 11	【满分】数据最节约的备份方法
     */
    public static void shujuzuijieyuebeifen() {
        Scanner sc = new Scanner(System.in);
        int max = 500;
        List<Integer> lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int count = 0;
        Collections.sort(lines, (a, b) -> b - a);
        while (lines.size() > 0) {
            int sum = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (sum + lines.get(i) <= max) {
                    sum += lines.get(i);
                    lines.remove(i);
                    i--;
                }
            }
            count++;
        }
        System.out.println(count);
    }

    /**
     * 10	【满分】寻找最大价值的矿堆
     */
    public static void zuidajiazhikuangdui() {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (!sc.hasNext("s")) {
            int[] lines = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            list.add(lines);
        }
        int jiazhi = 0;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).length; j++) {
                int n = list.get(i)[j];
                List<Integer> temp = new ArrayList<>();
                if (n != 0) {
                    temp.add(n);
                    list.get(i)[j] = 0;
                    kuangchanjiazhi(list, i, j, temp);
                    jiazhi = temp.stream().reduce(Integer::sum).get();
                    max = Math.max(max, jiazhi);
                }
            }
        }
        System.out.println(max);
    }

    public static void kuangchanjiazhi(List<int[]> list, int x, int y, List<Integer> temp) {
        if (x > 0 && list.get(x - 1)[y] != 0) {
            temp.add(list.get(x - 1)[y]);
            list.get(x - 1)[y] = 0;
            kuangchanjiazhi(list, x - 1, y, temp);
        }
        if (x < list.size() - 1 && list.get(x + 1)[y] != 0) {
            temp.add(list.get(x + 1)[y]);
            list.get(x + 1)[y] = 0;
            kuangchanjiazhi(list, x + 1, y, temp);
        }
        if (y > 0 && list.get(x)[y - 1] != 0) {
            temp.add(list.get(x)[y - 1]);
            list.get(x)[y - 1] = 0;
            kuangchanjiazhi(list, x, y - 1, temp);
        }
        if (y < list.get(0).length - 1 && list.get(x)[y + 1] != 0) {
            temp.add(list.get(x)[y + 1]);
            list.get(x)[y + 1] = 0;
            kuangchanjiazhi(list, x, y + 1, temp);
        }
    }

    /**
     * 9	We Are A Team
     */
    public static void weareateam() {
        Scanner sc = new Scanner(System.in);
        int[] lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = lines[0];
        int m = lines[1];
        if (n < 1 || m < 1 || n > 100000 || m > 100000) {
            System.out.println("NULL");
            return;
        }
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] linei = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = linei[0];
            int b = linei[1];
            int c = linei[2];
            if (c != 0 && c != 1 || (a < 1 || b < 1 || a > n || b > n)) {
                System.out.println("da pian zi");
            } else {
                if (c == 0) {
                    boolean found = false;
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).contains(a) || list.get(j).contains(b)) {
                            list.get(j).add(a);
                            list.get(j).add(b);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        list.add(new HashSet<Integer>() {{
                            add(a);
                            add(b);
                        }});
                    }
                } else {
                    boolean found = false;
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).contains(a) && list.get(j).contains(b)) {
                            found = true;
                            System.out.println("we are a team");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("we are not a team");
                    }
                }
            }
        }
    }

    /**
     * 8	书籍叠放
     */
    public static void shujidiefang() {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().replace("[[", "").replace("]]", "").split("],\\[");
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            list.add(new int[]{Integer.parseInt(lines[i].split(",")[0]), Integer.parseInt(lines[i].split(",")[1])});
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        int count = 1;
        int max = 0;
        for (int i = 0; i < list.size() - max; i++) {
            int pl = list.get(i)[0];
            int pw = list.get(i)[1];
            count = 1;
            for (int j = i + 1; j < list.size(); j++) {
                int cl = list.get(j)[0];
                int cw = list.get(j)[1];
                if (pl > cl && pw > cw) {
                    pl = cl;
                    pw = cw;
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }


    /**
     * 7	区间交集
     */
    public static void qujianjiaoji() {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        List<int[]> jiaoji = new ArrayList<>();
        while (!sc.hasNext("s")) {
            String[] line = sc.nextLine().split(" ");
            list.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
        }
        Collections.sort(list, (a, b) -> {
            return a[0] - b[0];
        });
        for (int i = 0; i < list.size(); i++) {
            int[] ai = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int[] aj = list.get(j);
                if (ai[1] >= aj[0]) {
                    if (ai[1] >= aj[1]) {
                        jiaoji.add(aj);
                    } else {
                        jiaoji.add(new int[]{aj[0], ai[1]});
                    }
                }
            }
        }
        if (jiaoji.size() == 0) {
            System.out.println("None");
            return;
        }
        Collections.sort(jiaoji, (a, b) -> {
            return a[0] - b[0];
        });
        int index = 0;
        int[] first = jiaoji.get(index);
        for (int i = 1; i < jiaoji.size(); i++) {
            int[] cur = jiaoji.get(i);
            if (first[1] >= cur[0]) {
                if (first[1] >= cur[1]) {
                    jiaoji.remove(cur);
                    i--;
                } else {
                    cur = new int[]{first[0], cur[1]};
                    jiaoji.set(i, cur);
                    jiaoji.remove(index);
                    i--;
                    index = i;
                    first = cur;
                }
            }
        }
        jiaoji.forEach(e -> {
            for (int i = 0; i < e.length; i++) {
                System.out.print(e[i] + " ");
            }
            System.out.println();
        });
    }

    /**
     * 6	找单词
     */
    public static void zhaodanci() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] strs = new String[n][];
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(",");
            strs[i] = line;
        }
        String word = sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[0].length; j++) {
                if (strs[i][j].equals(word.charAt(0) + "")) {
                    strs[i][j] = "";
                    list.add(i + "," + j);
                    if (zhandanciBack(strs, list, word, 0, i, j)) {
                        System.out.println(String.join(",", list));
                        return;
                    }
                    strs[i][j] = word.charAt(0) + "";
                    list.remove(list.size() - 1);
                }
            }
        }
        System.out.println("N");
    }

    public static boolean zhandanciBack(String[][] strs, List<String> list, String word, int i, int x, int y) {
        if (i == word.length() - 1) {
            return true;
        } else {
            i++;
            String s = word.charAt(i) + "";
            if (x > 0 && strs[x - 1][y].equals(s)) {
                list.add(x - 1 + "," + y);
                strs[x - 1][y] = "";
                if (zhandanciBack(strs, list, word, i, x - 1, y)) {
                    return true;
                } else {
                    list.remove(list.size() - 1);
                    strs[x - 1][y] = s;
                }
            }
            if (y > 0 && strs[x][y - 1].equals(s)) {
                list.add(x + "," + (y - 1));
                strs[x][y - 1] = "";
                if (zhandanciBack(strs, list, word, i, x, y - 1)) {
                    return true;
                } else {
                    list.remove(list.size() - 1);
                    strs[x][y - 1] = s;
                }
            }
            if (x < strs.length - 1 && strs[x + 1][y].equals(s)) {
                list.add(x + 1 + "," + y);
                strs[x + 1][y] = "";
                if (zhandanciBack(strs, list, word, i, x + 1, y)) {
                    return true;
                } else {
                    list.remove(list.size() - 1);
                    strs[x + 1][y] = s;
                }
            }
            if (y < strs.length - 1 && strs[x][y + 1].equals(s)) {
                list.add(x + "," + (y + 1));
                strs[x][y + 1] = "";
                if (zhandanciBack(strs, list, word, i, x, y + 1)) {
                    return true;
                } else {
                    list.remove(list.size() - 1);
                    strs[x][y + 1] = s;
                }
            }
            return false;
        }
    }

    /**
     * 5	字符串比较
     */
    public static void stringCompare() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int num = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            list.add(Math.abs(c1 - c2));
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            int c = list.get(i);
            if (c > num) continue;
            int sum = c;
            int temp = 1;
            for (int j = i + 1; j < list.size(); j++) {
                int c1 = list.get(j);
                sum += c1;
                if (num < sum) {
                    max = Math.max(max, temp);
                    break;
                } else {
                    temp++;
                }
            }
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }

    /**
     * 4	解压报文
     */
    public static void jieyabaowen() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Deque<Integer> integers = new ArrayDeque<>();
        Deque<String> strings = new ArrayDeque<>();
        String strs = new String();
        String ints = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                ints += c;
                if (strs.length() > 0) {
                    strings.push(strs);
                    strs = "";
                }
            } else if (c == '[') {
                integers.push(Integer.parseInt(ints));
                ints = "";
            } else if (c == ']') {
                int num = integers.pop();
                if (strs.length() > 0) {
                    strings.push(strs);
                    strs = "";
                }
                String strP = strings.pop();
                for (int j = 0; j < num; j++) {
                    strs += strP;
                }
                if (strings.isEmpty()) {
                    strings.push(strs);
                } else {
                    strings.push(strings.pop() + strs);
                }
                strs = "";
            } else {
                strs += c;
            }
        }
        System.out.println(strings.pop());
    }

    /**
     * 3	服务失效判断
     */
    public static void fuwuguzhang() {
        Scanner sc = new Scanner(System.in);
        String lines = sc.nextLine();
        List<String> fuwus = Arrays.stream(lines.split(",")).collect(Collectors.toList());
        Set<String> errors = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toSet());
        boolean found = true;
        while (found) {
            found = false;
            Set<String> temp = new HashSet<>();
            for (int i = 0; i < fuwus.size(); i++) {
                String s = fuwus.get(i);
                errors.forEach(e -> {
                    if (s.contains("-" + e)) {
                        temp.add(s.split("-")[0]);
                    }
                });
            }
            int len = errors.size();
            errors.addAll(temp);
            if (errors.size() > len) {
                found = true;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < fuwus.size(); i++) {
            String a = fuwus.get(i).split("-")[0];
            String b = fuwus.get(i).split("-")[1];
            if (!errors.contains(a)) {
                res.add(a);
            }
            if (!errors.contains(b)) {
                res.add(b);
            }
        }
        System.out.println(res.size() == 0 ? "," : String.join(",", res));
    }

    /**
     * 2	找最小数
     */
    public static void zhaozuixiaoshu() {
        Scanner sc = new Scanner(System.in);
        String[] num1 = sc.nextLine().split("");
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        zhaozuixiaoshuBackTracking(list, num1, 0, new ArrayList<String>(), num1.length - n);
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    public static void zhaozuixiaoshuBackTracking(List<Integer> list, String[] num1, int index, List<String> temp, int n) {
        if (temp.size() == n || index > num1.length) {
            if (temp.size() == n) {
                int m = Integer.parseInt(String.join("", temp));
                list.add(m);
            }
        } else {
            for (int i = index; i < num1.length; i++) {
                temp.add(num1[i]);
                zhaozuixiaoshuBackTracking(list, num1, ++index, temp, n);
                temp.remove(num1[i]);
            }
        }
    }

    /**
     * 1	宜居星球改造计划
     */
    public static void yijuxingqiugaizao() {
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<String>();
        while (!sc.hasNext("1")) {
            lines.add(sc.nextLine());
        }
        String[][] source = new String[lines.size()][];
        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            source[i] = lines.get(i).split(" ");
            for (int j = 0; j < source[i].length; j++) {
                if (source[i][j].equals("NO")) {
                    count++;
                }
            }
        }
        int row = source.length;
        int column = source[0].length;
        int day = 0;
        boolean found = true;
        while (found) {
            found = false;
            Set<String> list = new HashSet<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (source[i][j].equals("YES")) {
                        xingqiugaizao(source, i, j, list);
                    }
                }
            }
            day++;
            if (list.size() > 0) {
                count -= list.size();
                list.forEach(a -> {
                    source[Integer.parseInt(a.split(",")[0])][Integer.parseInt(a.split(",")[1])] = "YES";
                });
                found = true;
            }
        }
        if (count == 0) {
            System.out.println(day - 1);
        } else {
            System.out.println(-1);
        }
    }

    public static void xingqiugaizao(String[][] source, int i, int j, Set<String> list) {
        if (i > 0 && source[i - 1][j].equals("NO")) {
            list.add(i - 1 + "," + j);
        }
        if (i < source.length - 1 && source[i + 1][j].equals("NO")) {
            list.add(i + 1 + "," + j);
        }
        if (j > 0 && source[i][j - 1].equals("NO")) {
            list.add(i + "," + (j - 1));
        }
        if (j < source[0].length - 1 && source[i][j + 1].equals("NO")) {
            list.add(i + "," + (j + 1));
        }
    }


////初阶////////////////////////////////////////

    /**
     * 78	增强的strstr
     */
    public static void zengqiangdeStrStr() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        boolean isKuoHao = false;
        boolean isMatch = false;
        String temp = "";
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (isMatch) break;
            index = i;
            for (int j = 0; j < s2.length(); j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c2 == '[' || c2 == ']') {
                    isKuoHao = !isKuoHao;
                    if (!temp.equals("")) {
                        if (temp.contains(c1 + "")) {
                            i++;
                            temp = "";
                            if (j == s2.length() - 1) {
                                isMatch = true;
                                break;
                            }
                            continue;
                        } else {
                            i = index;
                            break;
                        }
                    }

                    continue;
                }
                if (isKuoHao) {
                    temp += c2;
                    continue;
                }
                if (Character.isLetter(c2)) {
                    if (c1 == c2) {
                        if (j == s2.length() - 1) {
                            isMatch = true;
                            break;
                        }
                        i++;
                    } else {
                        i = index;
                        break;
                    }
                }
            }

        }
        System.out.println(index);
    }

    /**
     * 77	内存资源分配
     */
    public static void neicunziyuanfenpei() {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(",");
        int[] lines = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            map.put(Integer.parseInt(s1[i].split(":")[0]), Integer.parseInt(s1[i].split(":")[1]));
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((a, b) -> {
            return a.getKey() - b.getKey();
        }).collect(Collectors.toList());
        Boolean[] res = new Boolean[lines.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < collect.size(); j++) {
                if (collect.get(j).getKey() > lines[i]) {
                    res[i] = true;
                    if (collect.get(j).getValue() == 1) {
                        collect.remove(j);
                        break;
                    }
                    collect.get(j).setValue(collect.get(j).getValue() - 1);
                    break;
                }
            }
            if (res[i] == null) {
                res[i] = false;
            }
        }
        String result = "";
        for (int i = 0; i < res.length; i++) {
            result += res[i] + ",";
        }
        System.out.println(result.substring(0, result.length() - 1));
    }

    /**
     * 76	跳房子I
     */
    public static void tiaofangzi1() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = sc.nextInt();
        boolean isOver = false;
        int[] a = Arrays.stream(s.replace("[", "").
                replace("]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        String res = "[";
        for (int i = 0; i < a.length - 1; i++) {
            if (isOver) break;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == count) {
                    isOver = true;
                    res += a[i] + ", " + a[j] + "]";
                    break;
                }
            }
        }
        System.out.println(res);
    }

    /**
     * 75	整型数组按个位值排序
     */
    public static void shuzupaixu() {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        Arrays.sort(s, (a, b) -> {
            char c1 = a.charAt(a.length() - 1);
            char c2 = b.charAt(b.length() - 1);
            if (c1 != c2) {
                return c1 - c2;
            }
            return 0;
        });
        System.out.println(String.join(",", s));
    }

    /**
     * 74	【满分】文件目录大小
     */
    public static void wenjianmuludaxiao() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, String> mapC = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            list.add(s);
            map.put(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]));
            mapC.put(Integer.parseInt(s.split(" ")[0]), s.split(" ")[2].replace("(", "").replace(")", ""));
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList();
        list1.add(n);
        wenjianmuluHandler(list1, res, map, mapC);
        int sum = res.stream().reduce(Integer::sum).get();
        System.out.println(sum);
    }

    public static void wenjianmuluHandler(List<Integer> list, List<Integer> res, Map<Integer, Integer> map, Map<Integer, String> mapC) {
        for (int i = 0; i < list.size(); i++) {
            res.add(map.get(list.get(i)));
            if (!"".equals(mapC.get(list.get(i)))) {
                List<Integer> lines = Arrays.stream(mapC.get(list.get(i)).split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
                wenjianmuluHandler(lines, res, map, mapC);
            }
        }
    }

    /**
     * 73	生日礼物
     */
    public static void shengruliwu() {
        Scanner sc = new Scanner(System.in);
        int[] cakes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] gifts = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int money = sc.nextInt();
        int res = 0;
        for (int i = 0; i < cakes.length; i++) {
            if (cakes[i] > money) continue;
            for (int j = 0; j < gifts.length; j++) {
                if (cakes[i] + gifts[j] <= money) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    /**
     * 72	矩阵元素的边界值
     */
    public static void juzhenyuansubianjiezhi() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] lines = s.replace("[[", "").replace("]]", "").split("],\\[");
        int[][] a = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            int[] ah = Arrays.stream(lines[i].split(",")).mapToInt(Integer::parseInt).toArray();
            a[i] = ah;
        }
        int[][] b = new int[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[j][i];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < b.length; i++) {
            int max = Arrays.stream(b[i]).max().getAsInt();
            min = Math.min(min, max);
        }
        System.out.println(min);
    }

    /**
     * 71	拔河比赛
     */
    public static void bahebisai() {
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<String>();
        while (!sc.hasNext("s")) {
            lines.add(sc.nextLine());
        }
        Collections.sort(lines, (a, b) -> {
            int x1 = Integer.parseInt(a.split(" ")[0]);
            int y1 = Integer.parseInt(a.split(" ")[1]);
            int x2 = Integer.parseInt(b.split(" ")[0]);
            int y2 = Integer.parseInt(b.split(" ")[1]);
            if (x1 == x2) {
                return y2 - y1;
            }
            return x2 - x1;
        });
        for (int i = 0; i < 10; i++) {
            System.out.println(lines.get(i));
        }
    }

    /**
     * 70	乘坐保密电梯
     */
    public static void chengzuobaomidianti() {
        Scanner sc = new Scanner(System.in);
        int floor = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        List<Integer> lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int mid = n / 2;
        int allFloor = lines.stream().reduce(Integer::sum).get();
        downFloor = null;
        arriveFloor = Integer.MAX_VALUE;
        isOver = false;
        diantiHandler(lines, 0, new ArrayList<Integer>(), floor, mid, allFloor);
        if (downFloor != null) {
            lines.removeAll(downFloor);
        }
        Collections.sort(lines, (a, b) -> b - a);
        Collections.sort(downFloor, (a, b) -> b - a);
        String result = "";
        for (int i = 0; i < mid; i++) {
            result += lines.get(i) + " " + downFloor.get(i) + " ";
        }
        if (mid * 2 < n) {
            result += lines.get(mid);
        } else {
            result = result.substring(0, result.length() - 1);
        }
        System.out.println(result);
    }

    //向下的数列
    static List<Integer> downFloor = null;
    static int arriveFloor = Integer.MAX_VALUE;//实际到达的楼层和应该到达的楼层差
    static boolean isOver = false;

    public static void diantiHandler(List<Integer> lines, int index, List<Integer> temp, int floor, int mid, int allFloor) {
        if (isOver) {
            return;
        }
        if (index == lines.size() || temp.size() == mid) {
            if (temp.size() == mid) {
                int sum = temp.stream().reduce(Integer::sum).get();
                int arrive = allFloor - sum * 2;
                if (arrive == floor) {
                    downFloor = new ArrayList<>(temp);
                    isOver = true;
                } else if (arrive < floor && ((floor - arrive) < arriveFloor)) {
                    arriveFloor = floor - arrive;
                    downFloor = new ArrayList<>(temp);
                }
            }
        } else {
            for (int i = index; i < lines.size(); i++) {
                temp.add(lines.get(i));
                diantiHandler(lines, ++index, temp, floor, mid, allFloor);
                temp.remove(lines.get(i));
            }
        }
    }

    /**
     * 69	【满分】构成的正方形数量
     */
    public static void zhengfangxingshuliang() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new int[]{x, y});
        }
        int count = 0;
        if (n < 4) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    for (int l = k + 1; l < list.size(); l++) {
                        if (isZFX(list.get(i), list.get(j), list.get(k), list.get(l))) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isZFX(int[] a, int[] b, int[] c, int[] d) {
        List<int[]> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        Map<Integer, Integer> map = new HashMap<>();
        int juli = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                int x = list.get(i)[0] - list.get(j)[0];
                int y = list.get(i)[1] - list.get(j)[1];
                juli = x * x + y * y;
                map.put(juli, map.getOrDefault(juli, 0) + 1);
            }
        }
        if (map.size() == 2 && (map.get(juli) == 2 || map.get(juli) == 4)) {//一共6个，一个2一个4，不分先后
            return true;
        }
        return false;
    }

    /**
     * 68	字符串分割
     */
    public static void zifuchaunfenge() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        hege = 0;
        fegeshu = 0;
        shuixianhuaHandler(s, 0);
        if (hege == 0) {
            System.out.println(0);
        } else if (hege > 1) {
            System.out.println(-1);
        } else {
            System.out.println(fegeshu);
        }

    }

    static int hege = 0;
    static int fegeshu = 0;


    public static void shuixianhuaHandler(String s, int num) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i);
            if (count > 999) {
                break;
            }
            if (isshuixianhuashu(count)) {
                if (i == s.length() - 1) {
                    hege++;
                    fegeshu = num + 1;
                } else {
                    shuixianhuaHandler(s.substring(i + 1), 1 + num);
                }
            }
        }
    }

    public static boolean isshuixianhuashu(int num) {
        String s = num + "";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int p = s.charAt(i) - '0';
            sum += Math.pow(p, 3);
        }
        return sum == num;
    }

    /**
     * 67	完全二叉树非叶子部分后序遍历
     */
    public static void wanquanerchashu() {
        Scanner sc = new Scanner(System.in);
        List<Integer> lines = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int index = (lines.size() - 2) / 2;//最后一个带叶子节点下标，画图可知
        TreeNode root = cengxuchuangjian(lines, index);
//        System.out.println(pre(root));
//        System.out.println(mid(root));
        System.out.println(rear(root));
    }


    //二叉树转集合前序  根左右  先加根，（在取根，加入右、左，取左，左完取右），如此重复
    public static List<Integer> pre(TreeNode t) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (t != null) {
            stack.push(t);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
        return list;
    }

    //二叉树转集合中序  左根右 设置当前为t，一直加左直到为空，出栈，判断右是否为空，不为空，当前置为右
    public static List<Integer> mid(TreeNode t) {
        List<Integer> list = new ArrayList();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = t;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }
            TreeNode pop = deque.pop();
            list.add(pop.val);
            cur = pop.right;
        }
        return list;
    }


    //二叉树转集合后序  左右根 当前为t，一直加左，左空看右，右不为空和前一个取出的值则当前为右，否则取出，设置pre为pop，cur为null
    public static List<Integer> rear(TreeNode t) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = t;
        TreeNode pre = t;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }
            TreeNode peek = deque.peek();
            if (peek.right != null && peek.right != pre) {
                cur = peek.right;
            } else {
                TreeNode pop = deque.pop();
                list.add(pop.val);
                pre = pop;
                cur = null;
            }
        }
        return list;
    }

    /**
     * 集合构建二叉树层序遍历--带叶子节点的
     *
     * @param lines
     * @return
     */
    public static TreeNode cengxuchuangjian(List<Integer> lines, int index) {
        TreeNode root = null;
        int i = 0;
        Queue<TreeNode> queue = new LinkedList();
        int data = lines.remove(0);
        root = new TreeNode(data);
        queue.offer(root);
        while (lines.size() > 0) {
            TreeNode node = queue.poll();
            if (!lines.isEmpty()) {
                node.left = new TreeNode(lines.remove(0));
                queue.offer(node.left);
                i++;
            }
            if (i == index) {
                break;
            }
            if (!lines.isEmpty()) {
                node.right = new TreeNode(lines.remove(0));
                queue.offer(node.right);
                i++;
            }
            if (i == index) {
                break;
            }
        }
        return root;
    }

    /**
     * 集合构建二叉树层序遍历
     *
     * @param lines
     * @return
     */
    public static TreeNode cengxuchaungjian(List<Integer> lines) {
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList();
        int data = lines.remove(0);
        root = new TreeNode(data);
        queue.offer(root);
        while (lines.size() > 0) {
            TreeNode node = queue.poll();
            if (!lines.isEmpty()) {
                node.left = new TreeNode(lines.remove(0));
                queue.offer(node.left);
            }
            if (!lines.isEmpty()) {
                node.right = new TreeNode(lines.remove(0));
                queue.offer(node.right);
            }
        }
        return root;
    }

    /**
     * 66	计算最接近的数
     */
    public static void jisuanzuijiejindeshu() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strings = line.replace("[", "").split("],");
        int[] lines = Arrays.stream(strings[0].split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(strings[1]);
        int[] nums = new int[lines.length];
        System.arraycopy(lines, 0, nums, 0, lines.length);
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int chaju = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < lines.length - k + 1; i++) {
            int sum = lines[i];
            for (int j = i + 1; j < k + i; j++) {
                sum -= lines[j];
            }
            if (Math.abs(sum - mid) <= chaju) {
                chaju = Math.abs(sum - mid);
                index = i;
            }
        }
        System.out.println(index);
    }

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
        if (Character.isDigit(s.charAt(0))) {
            temp = 1;
        }
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

    /**
     * tkv解码
     * 小断序  从右往左读 占两个字节
     */
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
    public static void daimabianjiqi() {
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

    /**
     * 41	热点网站统计
     */
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
                max = Math.max(max, all - lines[i - buzhong]);
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
