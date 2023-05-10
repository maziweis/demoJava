package com.example.demo;


import java.util.*;

public class HwOD {

    public static void main(String[] args) {
//        caizimi("conection", "connection,today");
//        Object res = muban(5, 3, new int[]{5, 5, 5, 5, 5});
//        Object res = commonCode("private_void_method", "public_void_method ");
//        getDanRuKou();
//        Object res = reverseStrings("yM eman si boB.");
        getStringSiteChar();
        System.out.println();
    }

    public static void newspaper2anonymousLetter(String news, String letters) {
        String[] newspaper = news.split(" ");
        String[] anonymousLetter = letters.split(" ");
        for (String s : anonymousLetter) {
            for (int i = 0; i < newspaper.length; i++) {
                String n = newspaper[i];
                if (s.length() == n.length() && change(s, n)) {
                    newspaper[i] = "";

                }
            }
        }
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
