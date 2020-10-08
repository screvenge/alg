package com.sc.alg.practise.回溯法;

public class 回溯法求二十四点 {
    private static final int[] nums = {6, 5, 4, 3};

    public static void main(String[] args) {
        // 给定一个数组，有四个数，通过加减乘除判断是否能够凑成24点
        System.out.println(recursion(0, new boolean[nums.length], 0));

    }

    private static boolean recursion(double total, boolean[] visit, int idx) {
        if (idx == nums.length) {
            return total == 24.0;
        }

        boolean flag;
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            // 如果第一个元素只有加和减
            if (idx == 0) {
                flag = recursion(nums[i], visit, idx + 1) || recursion(-nums[i], visit, idx + 1);
            } else {
                flag = recursion(total + nums[i], visit, idx + 1) || recursion(total - nums[i], visit, idx + 1)
                        || recursion(total * nums[i], visit, idx + 1) || recursion(total / nums[i], visit, idx + 1);
            }

            if (flag) {
                return true;
            }

            visit[i] = false;
        }

        return false;
    }
}
