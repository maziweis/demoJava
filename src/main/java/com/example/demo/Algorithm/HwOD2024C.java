package com.example.demo.Algorithm;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//https://blog.csdn.net/qfc_128220/article/details/127914382
public class HwOD2024C {
    public static void main(String[] args) {
        while (true) {
//            t1();
            t9();


        }

    }

    public static void t9() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("/");
            list.add(s);
        }
        String[] p = sc.nextLine().split(" ");
        int m = Integer.parseInt(p[0]);
        long count = list.stream().filter(s -> s.length > m && s[m].equals(p[1])).count();
        System.out.println(count);
    }

    public static void t8() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int all = 0;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char[] ci = (i + "").toCharArray();
                char[] cj = (j + "").toCharArray();
                int sum = 0;
                for (char c : ci) {
                    sum += c - '0';
                }
                for (char c : cj) {
                    sum += c - '0';
                }
                arr[i][j] = sum;
                if (arr[i][j] <= k) all++;
            }
        }
        System.out.println(all);
    }

    public static void t7() {
        Scanner sc = new Scanner(System.in);
        int[] tmp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = tmp[0]; // 产品数
        int n = tmp[1]; // 总投资
        int x = tmp[2]; // 总风险

        // 产品回报率序列
        int[] back = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 产品风险值序列
        int[] risk = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 产品投资额序列
        int[] invest = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max_invest_back = 0;
        HashMap<Integer, Integer> select = new HashMap<>();

        for (int i = 0; i < m; i++) {
            // 如果单个产品的投资风险未超过总风险，则投资单个产品
            if (risk[i] <= x) {
                // 产品I的投资额不能超过该产品的最大投资额，以及总投资
                int investI = Math.min(invest[i], n);
                // 产品投资回报
                int invest_back = investI * back[i];

                // 如果投资回报高于其他产品组合，那么选择该产品
                if (invest_back > max_invest_back) {
                    max_invest_back = invest_back;
                    select.clear();
                    select.put(i, investI);
                }
            } else {
                continue;
            }

            for (int j = i + 1; j < m; j++) {

                // 如果两个产品的风险和不超过了总风险，那么两个产品都选
                if (risk[i] + risk[j] <= x) {
                    // 产品I的投资额
                    int investI;
                    // 产品J的投资额
                    int investJ;

                    // 其中优先投资回报率大的
                    if (back[i] > back[j]) {
                        // 产品I回报率高，则能投多少投多少，最多不能超过min(总投资, 产品I的最多投资额)
                        investI = Math.min(n, invest[i]);
                        // 留给产品J的剩余钱未 n - investI, 而产品J最多投资invest[j]，因此取二者较小值
                        investJ = Math.min(n - investI, invest[j]);
                    } else {
                        investJ = Math.min(n, invest[j]);
                        investI = Math.min(n - investJ, invest[i]);
                    }

                    // 总投资回报
                    int invest_back = investI * back[i] + investJ * back[j];

                    // 如果当前产品组合的总回报更大，则选当前组合产品
                    if (invest_back > max_invest_back) {
                        max_invest_back = invest_back;
                        select.clear();
                        // select的key记录产品的ID，val记录产品的投资额
                        if (investI > 0) select.put(i, investI);
                        if (investJ > 0) select.put(j, investJ);
                    }
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < m; i++) {
            if (select.containsKey(i)) {
                sj.add(select.get(i) + "");
            } else {
                sj.add("0");
            }
        }

        System.out.println(sj);

    }

    public static void t6() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String max = "";
        Matcher matcher = Pattern.compile("((\\d+[+*-])*\\d+)").matcher(s);
        while (matcher.find()) {
            String s1 = matcher.group(0);
            max = max.length() > s1.length() ? max : s1;
        }
        max = max.replace("*", "@");
        Matcher m1 = Pattern.compile("(\\d+@\\d+)").matcher(max);
        while (m1.find()) {
            String s1 = m1.group(0);
            String res = Integer.parseInt(s1.split("@")[0]) * Integer.parseInt(s1.split("@")[1]) + "";
            max = max.replaceFirst(s1, res);
        }
        String l = "0", r = "";
        char fuhao = '+';
        long sum = 0;
        for (int i = 0; i < max.length(); i++) {
            char c = max.charAt(i);
            if (Character.isDigit(c)) {
                r += c;
                if (i == max.length() - 1) {
                    if (fuhao == '+') {
                        sum = Integer.parseInt(l) + Integer.parseInt(r);
                    } else {
                        sum = Integer.parseInt(l) - Integer.parseInt(r);
                    }
                }
            } else {
                if (fuhao == '+') {
                    sum = Integer.parseInt(l) + Integer.parseInt(r);
                    r = "";
                    l = sum + "";
                } else {
                    sum = Integer.parseInt(l) - Integer.parseInt(r);
                    r = "";
                    l = sum + "";
                }
                fuhao = c;
            }
        }
        System.out.println(sum);
    }

    public static void t5() {
        Scanner sc = new Scanner(System.in);
        int[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = prices.length;
        int[] res = new int[2 * n];
        // 记录题解
        System.arraycopy(prices, 0, res, 0, n);
        System.arraycopy(prices, 0, res, n, n);
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < res.length; j++) {
                if (prices[i] > res[j]) {
                    prices[i] += res[j];
                    break;
                }
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int num : prices) {
            sj.add(num + "");
        }
        System.out.println(sj);
    }


    public static void t4() {
        Scanner sc = new Scanner(System.in);
        int stus = sc.nextInt();
        int subs = sc.nextInt();
        sc.nextLine();
        String subNames = sc.nextLine();
        List<String> subNameList = Arrays.stream(subNames.split(" ")).collect(Collectors.toList());
        List<String> stuScores = new ArrayList<>();
        for (int i = 0; i < stus; i++) {
            stuScores.add(sc.nextLine());
        }
        String p = sc.nextLine();
        if (subNameList.contains(p)) {
            int i = subNameList.indexOf(p) + 1;
            Collections.sort(stuScores, (a, b) -> {
                int as = Integer.parseInt(a.split(" ")[i]);
                int bs = Integer.parseInt(b.split(" ")[i]);
                return bs - as;
            });
        } else {
            Collections.sort(stuScores, (a, b) -> {
                int aS = 0;
                int bS = 0;
                String[] aL = a.split(" ");
                String[] bL = b.split(" ");
                for (int i = 1; i < aL.length; i++) {
                    aS += Integer.parseInt(aL[i]);
                    bS += Integer.parseInt(bL[i]);
                }
                return bS - aS;
            });
        }
        String collect = stuScores.stream().map(s -> s.split(" ")[0]).collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    public static void t3() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] lines = new int[m][n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lines[i][j] = sc.nextInt();
                if (lines[i][j] != 0) {
                    map.put(lines[i][j], map.getOrDefault(lines[i][j], 0) + 1);
                }
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) continue;
            int l = 0, r = 0, t = 0, b = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    lines[i][j] = entry.getKey();
                    l = Math.min(l, j);
                    r = Math.max(r, j);
                    t = Math.min(t, i);
                    b = Math.max(b, i);
                }
            }
            max = Math.max(max, (r - l + 1) * (b - t + 1));
        }
        System.out.println(max);
    }

    public static void t2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer, Integer> money = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] temp = s.split(" ");
            if (i == 0) {
                for (int j = 0; j < temp.length; j++) {
                    money.put(j + 1, Integer.valueOf(temp[j]));
                }
            } else {
                int f = Integer.valueOf(temp[0]);
                map.put(f, map.getOrDefault(f, money.get(f)) + money.get(Integer.parseInt(temp[1])));
                max = Math.max(max, map.get(f));
            }
        }
        System.out.println(max);
    }

    public static void t1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();//行
        int k = n / m;//列
        if (n % m > 0) {
            k++;
        }
        int l = 0, t = 0, r = k - 1, b = m - 1;
        int x = 0, y = 0;
        int[][] res = new int[m][k];
        int i = 1;
        while (i <= n) {
            while (x == t && i <= n) {
                res[x][y++] = i++;
                if (y == r + 1) {
                    y--;
                    t++;
                }
            }
            x++;
            while (y == r && i <= n) {
                res[x++][y] = i++;
                if (x == b + 1) {
                    x--;
                    r--;
                }
            }
            y--;
            while (x == b && i <= n) {
                res[x][y--] = i++;
                if (y == l - 1) {
                    y++;
                    b--;
                }
            }
            x--;
            while (y == l && i <= n) {
                res[x--][y] = i++;
                if (x == t - 1) {
                    x++;
                    l++;
                }
            }
            y++;
        }
//        List<String> list = new ArrayList<>();
        for (int j = 0; j < res.length; j++) {
            String s = "";
            for (int o = 0; o < res[0].length; o++) {
                if (res[j][o] == 0) {
                    s += "* ";
                } else
                    s += res[j][o] + " ";
            }
            System.out.println(s.substring(0, s.length() - 1));
        }

    }
}
