package com.example.demo.Algorithm;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode {
    public static void main(String[] args) {


        int[] a = {1, 1, 2};
//        System.out.println(isValid("([]{})"));
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
//        new LeetCode().generateParenthesis(3);
//        System.out.println(isMatch("aabd", "a*"));
//        System.out.println(new LeetCode().findSubstring(s, words).toString());
        int[] nums1 = new int[]{5, 7, 7, 9, 9, 10};
        int m = 3;
        int[] nums2 = new int[]{2, 1, 1};
        int[][] nums3 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = 3;
//        new LeetCode().reverse(nums1);
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new LeetCode().rotate(nums3);
//        System.out.println(ss);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] ^= matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[n - 1 - i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> data = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> res = new ArrayList<>();
        permuteUniqueBack(data, res, new ArrayList<>(), new ArrayList<>());
        return res;
    }

    public void permuteUniqueBack(List<Integer> nums, List<List<Integer>> res, List<Integer> temp, List<Integer> tempI) {
        if (temp.size() == nums.size()) {
            if (!res.contains(temp))
                res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (tempI.contains(i)) continue;
                tempI.add(i);
                temp.add(nums.get(i));
                permuteUniqueBack(nums, res, temp, tempI);
                temp.remove(temp.size() - 1);
                tempI.remove(tempI.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteBack(nums, res, new ArrayList<>());
        return res;
    }

    public void permuteBack(int[] nums, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                permuteBack(nums, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int firstMissingPositive(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove(Integer.valueOf(nums[i]));
            }
        }
        if (list.size() == 0) return nums.length + 1;
        return list.stream().findFirst().get();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2Handle(candidates, target, 0, new ArrayList<>());
        return combinationSum2.stream().collect(Collectors.toList());
    }

    List<List<Integer>> combinationSum2 = new ArrayList<>();

    public void combinationSum2Handle(int[] candidates, int target, int index, List<Integer> tmp) {
        if (0 == target || index >= candidates.length) {
            if (target == 0 && !combinationSum2.contains(tmp)) {
                combinationSum2.add(new ArrayList<>(tmp));
            }
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i - 1] == candidates[i]) continue;
                if (target - candidates[i] < 0) break;
                tmp.add(candidates[i]);
                combinationSum2Handle(candidates, target - candidates[i], i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHandle(candidates, target, 0, new ArrayList<>());
        return combinationSum;
    }

    List<List<Integer>> combinationSum = new ArrayList<>();

    public void combinationSumHandle(int[] candidates, int target, int index, List<Integer> tmp) {
        if (0 >= target) {
            if (0 == target) {
                combinationSum.add(new ArrayList<>(tmp));
            }
        } else {
            for (int i = index; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                combinationSumHandle(candidates, target - candidates[i], i, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        char c = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
            else {
                sb.append(count + String.valueOf(c));
                count = 1;
                c = s.charAt(i);
            }
        }
        sb.append(count + String.valueOf(c));
        return sb.toString();
    }

    public void solveSudoku(char[][] board) {

    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] columns = new int[9][9];
            int[][][] subboxes = new int[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int index = c - '0' - 1;
                        rows[i][index]++;
                        columns[j][index]++;
                        subboxes[i / 3][j / 3][index]++;
                        if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    /**
     * ✔	[36]有效的数独	63.1%	Medium	0.0%
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        char[][] reverse = new char[9][9];
        for (int i = 0; i < board.length; i++) {
            char[] cs = board[i];
            if (!isValidArray(cs)) {
                return false;
            }
            for (int j = 0; j < board.length; j++) {
                reverse[j][i] = board[i][j];
            }
        }
        for (int i = 0; i < reverse.length; i++) {
            char[] cs = reverse[i];
            if (!isValidArray(cs)) {
                return isValidArray(cs);
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            char[] cs = new char[9];
            for (int j = 0; j < 3; j++) {
                cs[j] = board[i][j];
                cs[j + 3] = board[i + 1][j];
                cs[j + 6] = board[i + 2][j];
            }
            if (!isValidArray(cs)) {
                return isValidArray(cs);
            }
            cs = new char[9];
            for (int j = 0; j < 3; j++) {
                cs[j] = board[i][j + 3];
                cs[j + 3] = board[i + 1][j + 3];
                cs[j + 6] = board[i + 2][j + 3];
            }
            if (!isValidArray(cs)) {
                return isValidArray(cs);
            }
            cs = new char[9];
            for (int j = 0; j < 3; j++) {
                cs[j] = board[i][j + 6];
                cs[j + 3] = board[i + 1][j + 6];
                cs[j + 6] = board[i + 2][j + 6];
            }
            if (!isValidArray(cs)) {
                return isValidArray(cs);
            }
        }
        return true;
    }

    public boolean isValidArray(char[] board) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : board) {
            if (Character.isDigit(c)) {
                if (map.get(c) != null) {
                    return false;
                } else {
                    map.put(c, 1);
                }
            }
        }
        return true;
    }

    /**
     * ✔	[35]搜索插入位置	45.3%	Easy	0.0%
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (nums[l] < target) l++;
        return l;
    }

    /**
     * ✔	[34]在排序数组中查找元素的第一个和最后一个位置	42.7%	Medium	0.0%
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        int li = l;
        r = nums.length - 1;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (nums[l] != target) {
            l--;
        }
        return new int[]{li, l};
    }

    /**
     * ✔	[33]搜索旋转排序数组	43.9%	Medium	0.0%
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int m = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {//4 5 0 1 2 3
                l = m + 1;
            }
        }
        if (target >= nums[0]) {
            l = 0;
            r = m - 1;
            if (m == 0) {
                r = nums.length - 1;
            }
        } else {
            l = m;
            r = nums.length - 1;
        }
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                } else if (i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

//        public int removeDuplicates3(int[] nums) {
//        int k = 1;
//        int num = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[k - 1]) {
//                nums[k++] = nums[i];
//                num = 1;
//                continue;
//            }
//            num++;
//            if (num == 2) {
//                nums[k++] = nums[i];
//            }
//        }
//        return k;
//    }
//
//        public int removeDuplicates1(int[] nums) {
//        int k = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[k - 1]) {
//                nums[k++] = nums[i];
//            }
//        }
//        return k;
//    }
//
//        public int removeElement1(int[] nums, int val) {
//        int p = nums.length - 1;
//        for (int i = p; i >= 0; i--) {
//            if (nums[i] == val) {
//                int temp = nums[i];
//                nums[i] = nums[p];
//                nums[p] = temp;
//                p--;
//            }
//        }
//        return p + 1;
//    }
//
//        public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int p = nums1.length - 1;
//        m--;
//        n--;
//        while (m >= 0 && n >= 0) {
//            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
//        }
//        System.arraycopy(nums2, 0, nums1, 0, n + 1);
//    }
//
//        public void merge2(int[] nums1, int m, int[] nums2, int n) {
//        int len = m + n - 1;
//        int len1 = m - 1;
//        int len2 = n - 1;
//        while (len1 >= 0 && len2 >= 0) {
//            nums1[len--] = nums1[len1] >= nums2[len2] ?
//                    nums1[len1--] : nums2[len2--];
//        }
//        //如果num1的数全部遍历完毕了，但len2还没有遍历，所以只要将len2剩余的元素全部复制到len1中，此时len2的长度根据len2中剩下的元素的长度来决定
//        //但是如果num2全部遍历完了，那么此时的len2就是为-1了，所以当你在将num2复制到num1时，复制的长度为0，所以不复制任何元素过去
//        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
//    }
//
//        public void merge1(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2, 0, nums1, m, n);
//        for (int i = 0; i < nums1.length - 1; i++) {
//            for (int j = i + 1; j < nums1.length; j++) {
//                if (nums1[i] > nums1[j]) {
//                    int temp = nums1[i];
//                    nums1[i] = nums1[j];
//                    nums1[j] = temp;
//                }
//            }
//        }
//    }
//
//        public boolean test() {
//        ListNode ln = new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(6, new ListNode(8)))));
//        ListNode ln1 = new ListNode(1);
//        ListNode ln2 = new ListNode(3, new ListNode(6));
//        ListNode ln3 = new ListNode(3, new ListNode(6, new ListNode(8)));
//        ListNode[] listNodes = new ListNode[]{ln, ln1, ln2};
//        ListNode res = reverseKGroup2(ln, 3);
//        return true;
//    }

    /**
     * ✔	[31]下一个排列	38.6%	Medium	0.0%
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        boolean found = false;
        int v = Integer.MAX_VALUE;
        int index = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    if (nums[j] < v) {
                        index = j;
                        v = nums[j];
                        found = true;
                    }
                }
            }
            if (found) {
                swap(nums, i, index);
                Arrays.sort(nums, i + 1, nums.length);
                break;
            }
        }
        if (!found) {
            Arrays.sort(nums);
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    /**
     * ✔	[30]串联所有单词的子串	39.5%	Hard	0.0%
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        Set<String> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int m = words.length;
        int n = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        Map<String, Integer> match = new HashMap<>();
        for (int i = 0; i < s.length() - m * n + 1; i++) {
            match.clear();
            String s1 = s.substring(i, i + m * n);
            for (int j = 0; j < s1.length(); j += n) {
                String s2 = s1.substring(j, j + n);
                match.put(s2, match.getOrDefault(s2, 0) + 1);
            }
            boolean b = compareMap(map, match);
            if (b) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean compareMap(Map<String, Integer> map, Map<String, Integer> match) {
        if (map.size() != match.size()) return false;
        String s1 = map.entrySet().stream().map(s -> s.getKey() + s.getValue()).sorted().collect(Collectors.joining());
        String s2 = match.entrySet().stream().map(s -> s.getKey() + s.getValue()).sorted().collect(Collectors.joining());
        return s1.equals(s2);
    }


    /**
     * ✔	[29]两数相除	Medium
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        int k = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            k = -1;
        }
        tempk = 0;
        divideHalf(dividend > 0 ? -dividend : dividend, divisor > 0 ? -divisor : divisor, 1);
        return k == 1 ? tempk : -tempk;
    }

    int tempk = 0;

    public void divideHalf(int dividend, int divisor, int k) {
        if (dividend > divisor) return;
        int divisor1 = divisor;
        if (divisor1 >= -214748364) {
            while (dividend <= tenValue(divisor1)) {
                divisor1 = tenValue(divisor1);
                k = tenValue(k);
                if (divisor1 < -214748364) break;
            }
        }
        tempk += k;
        divideHalf(dividend - divisor1, divisor, 1);
    }

    public int tenValue(int divisor) {
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += divisor;
        }
        return res;
    }

    /**
     * ✔	[28]找出字符串中第一个匹配项的下标	Medium
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * ✔	[27]移除元素	Easy
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * ✔	[26]删除有序数组中的重复项	Easy
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * ✔	[25]K 个一组翻转链表	Hard
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }


    /**
     * 递归反转链表
     *
     * @param head
     */
    private ListNode reverse1(ListNode head) {
        reverseNode(head);
        return head;
    }

    LinkedList<Integer> reverseNodeList = new LinkedList<Integer>();

    /**
     * 递归反转链表
     *
     * @param head
     */
    private void reverseNode(ListNode head) {
        reverseNodeList.add(head.val);
        if (head.next != null) {
            reverse1(head.next);
        }
        head.val = reverseNodeList.pollFirst();
    }

    /**
     * 循环反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = -1;
        while (cur.next != null) {
            i++;
            if (i % k == 0) {
                try {
                    reverseKGroupVal(cur, 1, k, list);
                } catch (Exception e) {

                }
            }
            cur = cur.next;

        }
        return head;
    }

    public void reverseKGroupVal(ListNode head, int i, int k, LinkedList<Integer> list) {
        if (head == null) throw new IllegalArgumentException("");
        list.add(head.val);
        if (i < k) {
            i++;
            reverseKGroupVal(head.next, i, k, list);
        }
        head.val = list.pollFirst();
    }

    /**
     * ✔	[24]两两交换链表中的节点	Medium
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        int i = 0;
        int temp = 0;
        while (cur != null) {
            if (i % 2 == 0) {
                if (cur.next != null) {
                    temp = cur.val;
                    cur.val = cur.next.val;
                }
            } else {
                cur.val = temp;
            }
            i++;
            cur = cur.next;
        }
        return head;
    }

    /**
     * ✔	[23]合并 K 个升序链表	Hard
     *
     * @param listNodes
     * @return
     */
    public ListNode mergeKLists1(ListNode[] listNodes) {
        return merge2(listNodes, 0, listNodes.length - 1);
    }

    public ListNode merge2(ListNode[] listNodes, int start, int end) {
        if (start == end) {
            return listNodes[start];
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        return mergeTwoLists1(merge2(listNodes, start, mid), merge2(listNodes, mid + 1, end));
    }

    public ListNode mergeTwoLists1(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode cur = head, l = a, r = b;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        cur.next = l == null ? r : l;
        return head.next;
    }

    /**
     * [22]括号生成	Medium
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     * [22]括号生成	Medium
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        System.out.println(String.valueOf(current));
        System.out.println(pos);
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    /**
     * ✔	[21]合并两个有序链表	Easy
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode list = new ListNode(0);
        ListNode cur = list;
        ListNode l = list1;
        ListNode r = list2;
        while (l != null || r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
                if (l == null) {
                    cur.next = r;
                    break;
                }
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
                if (r == null) {
                    cur.next = l;
                    break;
                }
            }
        }
        return list.next;
    }

    /**
     * ✔	[20]有效的括号	Easy
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put('{', '}');
            put('[', ']');
            put('(', ')');
        }};
        if ((s.length() & 1) == 1) {
            return false;
        }
        LinkedList<Character> list = new LinkedList();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                list.add(c);
            } else if (list.size() == 0 || map.get(list.pollLast()) != c) return false;
        }
        if (list.size() == 0) return true;
        else return false;
    }


    /**
     * ✔	[19]删除链表的倒数第 N 个结点	Medium
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (null == head) return null;
        ListNode dummy = new ListNode(0, head);
        int length = getLength(dummy);
        ListNode cur = dummy;
        for (int i = 1; i < length - n; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * ✔	[19]删除链表的倒数第 N 个结点	Medium
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }


    /**
     * ✔	[18]四数之和	Medium
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int l = j + 1, r = len - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r] - target;
                    if (sum == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else if (sum > 0) {
                        r--;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else {
                        l++;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                    }
                }
            }
        }
        return list;
    }

    static List<String> letterCombinations = new ArrayList<String>();

    /**
     * ✔	[17]电话号码的字母组合	Medium
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        iterStr(digits, 0);
        return letterCombinations;
    }

    static void iterStr(String s, int index) {
        if (s.length() == index) return;
        String[] temp = num2String(s.charAt(index++) - '0');
        if (letterCombinations.size() == 0) {
            for (int i = 0; i < temp.length; i++) {
                letterCombinations.add(temp[i]);
            }
        } else {
            int count = letterCombinations.size();
            for (int i = 0; i < count; i++) {
                String str = letterCombinations.get(0);
                letterCombinations.remove(0);
                for (int j = 0; j < temp.length; j++) {
                    letterCombinations.add(str + temp[j]);
                }
            }
        }
        iterStr(s, index);
    }

    /**
     * ✔	[17]电话号码的字母组合	Medium
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        if (digits.length() == 1) return Arrays.asList(num2String(Integer.parseInt(digits)));
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < digits.length(); i++) {
            queueLetterCombinations2(queue, num2String(digits.charAt(i) - '0'));
        }
        List<String> result = new ArrayList<String>();
        for (String s : queue) {
            result.add(s);
        }
        return result;
    }

    /**
     * 将数组中字符串遍历加到队列字符后面
     *
     * @param queue
     * @param digits
     */
    public static void queueLetterCombinations2(Queue<String> queue, String[] digits) {
        if (queue.size() == 0) {
            for (String digit : digits) {
                queue.add(digit);
            }
        } else {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String s = queue.poll();
                for (String digit : digits) {
                    queue.add(s + digit);
                }
            }
        }
    }

    /**
     * ✔	[17]电话号码的字母组合	Medium
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        if (digits.length() == 1) return Arrays.asList(num2String(Integer.parseInt(digits)));
        int num = 1;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) == '7' || digits.charAt(i) == '9') {
                num *= 4;
            } else {
                num *= 3;
            }
        }
        String[] result = new String[num];
        for (int i = 0; i < digits.length(); i++) {
            String[] temp = num2String(digits.charAt(i) - '0');
            for (int j = 0; j < result.length; j++) {
                if (i == 0) {
                    result[j] = temp[j / (num / temp.length)];
                } else {
                    result[j] += temp[j % temp.length];
                }
            }
            Arrays.sort(result);
        }
        return Arrays.asList(result);
    }

    public static String[] num2String(int num) {
        switch (num) {
            case 2:
                return new String[]{"a", "b", "c"};
            case 3:
                return new String[]{"d", "e", "f"};
            case 4:
                return new String[]{"g", "h", "i"};
            case 5:
                return new String[]{"j", "k", "l"};
            case 6:
                return new String[]{"m", "n", "o"};
            case 7:
                return new String[]{"p", "q", "r", "s"};
            case 8:
                return new String[]{"t", "u", "v"};
            default:
                return new String[]{"w", "x", "y", "z"};
        }
    }

    /**
     * ✔	[16]最接近的三数之和	Medium
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r] - target;
                if (i == 0 && l == 1) {
                    res = sum;
                }
                if (sum == 0) {
                    return target;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
                if (Math.abs(sum) < Math.abs(res)) {
                    res = sum;
                }
            }
        }
        return res + target;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) return result;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

    /**
     * ✔	[14]最长公共前缀	Easy
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1 || strs[0].equals("")) return strs[0];
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            temp = longestCommonPrefixFor2S(temp, strs[i]);
            if (temp.equals("")) return temp;
        }
        return temp;
    }

    /**
     * 求两个字符串的最大公共前缀
     *
     * @param a
     * @param b
     * @return
     */
    public static String longestCommonPrefixFor2S(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return a.substring(0, i);
    }

    /**
     * ✔	[14]最长公共前缀	Easy
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1 || strs[0].equals("")) return strs[0];
        String temp = strs[0];
        String res = "";
        for (int i = 1; i < strs.length; i++) {
            int m = temp.length();
            res = "";
            int n = 0;
            while (n < m) {
                if (strs[i].length() > n && strs[i].charAt(n) == temp.charAt(n)) {
                    res += strs[i].charAt(n++);
                } else {
                    break;
                }
            }
            temp = res;
        }
        return res;
    }

    /**
     * ✔	[14]最长公共前缀	Easy
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1 || strs[0].equals("")) return strs[0];
        int len = strs.length;
        int index = 1;
        String res = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char s = strs[0].charAt(i);
            while (index < len) {
                if (strs[index].equals("") || strs[index].length() == i) return res;
                char t = strs[index++].charAt(i);
                if (s != t) {
                    return res;
                }
            }
            index = 1;
            res += s;
        }
        return res;
    }


    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * ✔	[13]罗马数字转整数	Easy
     *
     * @param s
     * @return
     */
    public static int romanToInt2(String s) {
        int res = 0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = getValue(s.charAt(i));
            if (pre < cur) {
                res -= pre;
            } else {
                res += pre;
            }
            pre = cur;
        }
        return res + pre;
    }

    /**
     * ✔	[13]罗马数字转整数	Easy
     *
     * @param s
     * @return
     */
    public static int romanToInt1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && symbolValues.get(s.charAt(i)) < symbolValues.get(s.charAt(i + 1))) {
                res -= symbolValues.get(s.charAt(i));
            } else {
                res += symbolValues.get(s.charAt(i));
            }
        }
        return res;
    }

    public static int romanToInt(String s) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int res = 0;
        for (int i = 0; i < romans.length; i++) {
            String r = romans[i];
            if (r.length() == 1) {
                if (("" + s.charAt(0)).equals(r)) {
                    res += numbers[i];
                    s = s.substring(1);
                    i--;
                }
            }
            if (r.length() == 2 && s.length() > 1) {
                if (("" + s.charAt(0) + s.charAt(1)).equals(r)) {
                    res += numbers[i];
                    s = s.substring(2);
                    i--;
                }
            }
            if (s.equals("")) break;
        }
        return res;
    }

    /**
     * ✔	[12]整数转罗马数字	Medium
     *
     * @param num
     * @return
     */
    //    字符 数值 I 1 V 5 X 10 L 50 C 100 D 500 M 1000  1 <= num <= 3999
    public static String intToRoman1(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder sb = new StringBuilder();
        sb.append(thousands[num / 1000]);
        sb.append(hundreds[num % 1000 / 100]);
        sb.append(tens[num % 100 / 10]);
        sb.append(ones[num % 10]);
        return sb.toString();
    }

    /**
     * ✔	[12]整数转罗马数字	Medium
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String res = "";
        for (int i = 0; i < numbers.length; i++) {
            int v = numbers[i];
            while (num >= v) {
                num -= v;
                res += romans[i];
            }
            if (num == 0) {
                break;
            }
        }
        return res;
    }

    /**
     * ✔	[11]盛最多水的容器	Medium
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int res = 0;
        int i = 0, j = len - 1;
        int temp = 0;
        while (i < j) {
            if (height[i] > height[j]) {
                temp = height[j] * (j - i);
                j--;
            } else {
                temp = height[i] * (j - i);
                i++;
            }
            res = temp > res ? temp : res;
        }
        return res;
    }

    /**
     * [10]正则表达式匹配	Hard
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        // todo 没看懂
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /**
     * ✔	[9]回文数	Easy
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int y = x;
        if (x < 0) return false;
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            x /= 10;
        }
        if (res == y) {
            return true;
        }
        return false;
    }

    /**
     * ✔	[8]字符串转换整数 (atoi)	Medium
     *
     * @param s
     * @return
     */
    public static int myAtoi2(String s) {
        int sign = 1, ans = 0, index = 0;
        char[] array = s.toCharArray();
        while (index < array.length && array[index] == ' ') {
            index++;
        }
        if (index < array.length && (array[index] == '-' || array[index] == '+')) {
            sign = array[index++] == '-' ? -1 : 1;
        }
        while (index < array.length && array[index] <= '9' && array[index] >= '0') {
            int digit = array[index++] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
        }
        return ans * sign;
    }

    /**
     * ✔	[8]字符串转换整数 (atoi)	Medium
     *
     * @param s
     * @return
     */
    public static int myAtoi1(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) return 0;
        s = s.trim();
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        int i = 0;
        int res = 0;
        int p = Integer.MAX_VALUE / 10;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c < '0' || c > '9') {
                break;
            }
            if (res > p || (res == p && (c - '0') > 7)) {
                return Integer.MAX_VALUE;
            }
            if (res < -p || (res == -p && (c - '0') == 9)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + (c - '0') * sign;
        }
        return res;
    }

    /**
     * ✔	[8]字符串转换整数 (atoi)	Medium
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        int len = s.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = s.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    /**
     * ✔	[7]整数反转	Medium
     *
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        int p = Integer.MAX_VALUE / 10;
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            if (res > p || (res == p && temp > 7)) {
                return 0;
            }
            if (res < -p || (res == -p && temp == -9)) {
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }

    /**
     * ✔	[7]整数反转	Medium
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        int p = Integer.MAX_VALUE / 10;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > p || (res == p && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -p || (res == -p && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    /**
     * ✔	[6]N 字形变换	Medium
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag *= -1;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            res.append(stringBuilder);
        }
        return res.toString();
    }

    /**
     * ✔	[6]N 字形变换	Medium
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    /**
     * ✔	[5]最长回文子串	Medium 解法 5: Manacher's Algorithm 马拉车算法。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome7(String s) {
        //todo 没看懂
        String t = preProcess(s);
        int n = t.length();
        int[] p = new int[n];
        int c = 0, r = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * c - i;
            if (r > i) {
                p[i] = Math.min(r - i, p[i_mirror]);
            } else {
                p[i] = 0;
            }
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static String preProcess(String s) {
        String result = "^";
        for (int i = 0; i < s.length(); i++) {
            result += "#" + s.charAt(i);
        }
        return result + "#$";
    }

    /**
     * ✔	[5]最长回文子串	Medium
     *
     * @param s
     * @return
     */
    public static String longestPalindrome6(String s) {
        int len = s.length();
        int start = 0;
        int end = 0;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            int tempLen = 1;
            l = i - 1;
            r = i + 1;
            while (l >= 0 && s.charAt(l) == s.charAt(i)) {//找左边相等的字符
                tempLen++;
                l--;
            }
            while (r < len && s.charAt(r) == s.charAt(i)) {//找右边相等的字符
                tempLen++;
                r++;
            }
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {//找两边相等的字符
                tempLen += 2;
                l--;
                r++;
            }
            if (tempLen > maxLen) {
                maxLen = tempLen;
                start = l + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * ✔	[5]最长回文子串	Medium
     *
     * @param s
     * @return
     */
    public static String longestPalindrome5(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i); //回文串是奇数
            int len2 = expand(s, i, i + 1);//回文串是偶数
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩展，从中间往两边找两边相等的字符 a-> bab
     *
     * @param s
     * @param l
     * @param r
     * @return
     */
    public static int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * ✔	[5]最长回文子串	Medium
     *
     * @param s
     * @return
     */
    public static String longestPalindrome4(String s) {
        int len = s.length();
        String res = "";
        boolean[] p = new boolean[len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= i; j--) {
                p[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || p[j - 1]);
                if (p[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * ✔	[5]最长回文子串	Medium
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        int len = s.length();
        String res = "";
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                p[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || p[i + 1][j - 1]);
                if (p[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * ✔	[5]最长回文子串	Medium
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        int length = s.length();
        int maxLen = 0;
        String maxPal = "";
        boolean[][] result = new boolean[length][length];
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) break;
                result[start][end] = (len == 1 || len == 2 || result[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (result[start][end] && len > maxLen) {
                    maxLen = len;
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }

    /**
     * ✔	[5]最长回文子串	Medium
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        int len = s.length();
        int[][] arr = new int[len][len];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i;
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /**
     * ✔	[5]最长回文子串	Medium
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int maxL = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String match = s.substring(i, j);
                if (isPalindromic(match)) {
                    if (match.length() > maxL) {
                        maxL = match.length();
                        ans = match;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 是否回文字符串
     *
     * @param s
     * @return
     */
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * ✔	[4]寻找两个正序数组的中位数	Hard
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int len = l1 + l2;
        int mid = len / 2 + 1;
        if ((len & 1) == 0) {
            return (getKth1(nums1, nums2, mid - 1) + getKth1(nums2, nums1, mid)) / 2.0;
        } else {
            return getKth1(nums1, nums2, mid);
        }
    }

    /**
     * 获取两个正序数组的第K个数
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static int getKth1(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        int i1 = 0, i2 = 0;
        while (true) {
            if (i1 == l1) {
                return nums2[i2 + k - 1];
            }
            if (i2 == l2) {
                return nums1[i1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i1], nums2[i2]);
            }
            int half = k / 2;
            int ni1 = Math.min(i1 + half, l1) - 1, ni2 = Math.min(i2 + half, l2) - 1;
            int pivot1 = nums1[ni1], pivot2 = nums2[ni2];
            if (pivot1 <= pivot2) {
                k -= ni1 - i1 + 1;
                i1 = ni1 + 1;
            } else {
                k -= ni2 - i2 + 1;
                i2 = ni2 + 1;
            }
        }
    }


    /**
     * ✔	[4]寻找两个正序数组的中位数	Hard
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1;
        int right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else return right;
    }


    /**
     * 滑块算法，从左往右滑动，找到子串最大长度大小
     * ✔	[3]无重复字符的最长子串	Medium
     *
     * @param s
     * @return
     */
    public static int longtestSubString(@NotNull String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int mapLength = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            mapLength = Math.max(mapLength, i - left + 1);
        }
        return mapLength;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * ✔	[2]两数相加	Medium
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return pre.next;
    }

    /**
     * ✔	[1]两数之和	Easy
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
