package com.sc.alg.practise.回溯法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 回溯法分割回文数 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, stack, res);
        return res;
    }

    /**
     * @param s 字符串
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param stack  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    private void backtracking(String s, int start, int len, Deque<String> stack, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < len; i++) {

            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝
            if (!checkPalindrome(s, start, i)) {
                continue;
            }

            stack.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, stack, res);
            stack.removeLast();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划先把回文子串的结果记录在一个表格里
     *
     * @param str
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
