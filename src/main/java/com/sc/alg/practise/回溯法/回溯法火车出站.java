package com.sc.alg.practise.回溯法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 回溯法火车出站 {
    private static final int[] nums = {1,2,3};
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        // 火车有进站和出站两种状态 所以索引得换成两个数字来维护(out可以看做原来的idx)
        // 进出站的特性就是先进后出, 所以需要建立一个stack来维护
        int in = 0;
        int out = 0;
        Stack<Integer> stack = new Stack<>();
        recursion(in, out, list, new ArrayList<>(), stack);
        System.out.println(list);
    }

    private static void recursion(int in, int out, List<List<Integer>> list, List<Integer> each, Stack<Integer> stack) {
        if (out == nums.length) {
            list.add(new ArrayList<>(each));
            return;
        }

        // 根据栈的状态判断是否要出站（代替visit）
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                if (in >= nums.length) {
                    continue;
                }

                stack.push(nums[in]);
                recursion(in + 1, out, list, each, stack);
                stack.pop();
            } else {
                // 后出栈
                if (stack.isEmpty()) {
                     continue;
                }

                int temp = stack.pop();
                each.add(temp);
                recursion(in, out + 1, list, each, stack);
                stack.push(temp);
                each.remove(out);
            }
        }
    }
}
