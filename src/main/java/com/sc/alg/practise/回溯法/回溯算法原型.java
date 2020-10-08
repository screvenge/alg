package com.sc.alg.practise.回溯法;

import java.util.ArrayList;
import java.util.List;

public class 回溯算法原型 {

    private static final int[] nums = {1,2,3,4};
    public static void main(String[] args) {
        // 写一个算法使得一个数组里的元素所有排列组合情况
        List<List<Integer>> list = new ArrayList<>();
        recursion(0, list, new ArrayList<>(), new boolean[nums.length]);

        System.out.println(list);
    }

    /**
     * @param idx 记录了each中元素的个数, 可以使用each.size - 1代替, 主要是为了提升效率以空间换时间
     * @param list 返回结果的list
     * @param each 每一行的list, 达到长度后复制到总的list里
     * @param visit 回溯是否访问过节点的数组
     */
    private static void recursion(int idx, List<List<Integer>> list, List<Integer> each, boolean[] visit) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(each));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }

            each.add(nums[i]);
            visit[i] = true;
            recursion(idx + 1, list, each, visit);
            // 回溯法的关键所在, 结束了需要退回初始状态
            visit[i] = false;
            each.remove(idx);
        }
    }
}
