package com.sc.alg.practise;

import com.sc.alg.practise.common.AlgUtil;

public class 下一次排序 {

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,4,3};
        new 下一次排序().nextPermutation(arr);

    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        AlgUtil.print(nums);

        // 只交换了两个元素, 如 1243 -> 1342 还要考虑4和2的顺序
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
