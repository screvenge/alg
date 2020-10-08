package com.sc.alg.practise.指针法;

/**
 * 双指针的算法就是通过合理的运算, 排除不可能情况, 简化暴力穷举法
 */
public class 双指针法 {

    public static void main(String[] args) {
        双指针法 s = new 双指针法();
        System.out.println(s.maxArea(new int[] {1,3,2,5,25,24,5}));
    }

    public int maxArea(int[] height) {

        if (height == null || height .length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            // 抛弃最左还是抛弃最右，抛弃最小的那一个
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
