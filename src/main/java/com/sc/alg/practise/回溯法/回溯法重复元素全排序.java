package com.sc.alg.practise.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 会有重复的元素, 重复的元素不算相同位置
 */
public class 回溯法重复元素全排序 {
    public static void main(String[] args) {
        回溯法重复元素全排序 s = new 回溯法重复元素全排序();
        System.out.println(s.permuteUnique(new int[]{1, 2, 2}));
    }

    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];

        // 从小到大排列，这样重复元素就在一起了
        Arrays.sort(nums);
        backtrack(nums, list, 0, perm);
        return list;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 因为从小到大排序, 所以nums[i] == nums[i - 1]代表了两个元素相同
            // 同时上个点没有被visit。为什么取非? 因为这个点已经没访问过了，上个点如果访问了说明不影响（这个点是在后面的那个2）
            // 意思就是1 2 2要去重, 但是1 2如果是2是前面一个2,可以正常添加, 2是后面一个2就不能添加了(122已经进入list)
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;

            backtrack(nums, ans, idx + 1, perm);

            // perm是用来循环添加的所以去除, 重新添加
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
