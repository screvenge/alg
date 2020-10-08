package com.sc.alg.practise;

import java.util.ArrayList;
import java.util.List;

public class 求所有子集 {
    public static void main(String[] args) {
        System.out.println(new 求所有子集().subsets(new int[] {1, 2, 3}));
    }

    List<Integer> each = new ArrayList<>();

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        // <<代表二进制移动, 3个元素的数组最多有2^3个子集
        int maxLengh = 1 << n;

        for (int i = 0; i < maxLengh; i++) {
            each.clear();
            for (int j = 0; j < n; j++) {
                // 与运算可以求子集
                if ((i & (1 << j)) != 0) {
                    each.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(each));
        }
        return ans;
    }
}
