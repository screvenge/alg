package com.sc.alg.practise;

/**
 * 使用空间复杂度O1 来解决问题
 * 我们使用了两个指针，i 是遍历指针，指向当前遍历的元素；j 指向下一个要覆盖元素的位置。
 * 同样，我们用 count 记录当前数字出现的次数。count 的最小计数始终为 1。
 * 我们从索引 1 开始一次处理一个数组元素。
 * 若当前元素与前一个元素相同，即 nums[i]==nums[i-1]，则 count++。若 count > 2，则说明遇到了多余的重复项。在这种情况下，我们只向前移动 i，而 j 不动。
 * 若 count <=2，则我们将 i 所指向的元素移动到 j 位置，并同时增加 i 和 j。
 * 若当前元素与前一个元素不相同，即 nums[i] != nums[i - 1]，说明遇到了新元素，则我们更新 count = 1，并且将该元素移动到 j 位置，并同时增加 i 和 j。
 * 当数组遍历完成，则返回 j。
 */
public class 数组删除重复元素 {
    public static void main(String[] args) {
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        int count = 1;

        // count始终记为本元素的个数
        // j视为新数组的下标
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            // 只要小于2就可以正常插入, 且j一定小于i, 不会影响后面的遍历
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}