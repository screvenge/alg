package com.sc.alg.practise;

import com.sc.alg.practise.common.AlgUtil;

public class 归并算法 {

    public static void main(String[] args) {
        int[] arr = AlgUtil.arr;
        mergeSort(arr, 0, AlgUtil.arr.length);
        AlgUtil.print(arr);
    }

    /**
     * 本质是二分算法的一种
     * 8, 4, 2, 9, 3, 0, 1, 6, 5, 7
     * @param arr 数组
     * @param start 开始
     * @param end 结束
     */
    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end - 1) {
            return;
        }

        int half = (start + end) / 2;

        // 分两半排序
        mergeSort(arr, start, half);
        mergeSort(arr, half, end);

        int i = start;
        int j = half;
        int[] temp = arr.clone();

        // 合并
        for (int idx = start; idx < end; idx++) {
            if (i >= half) {
                arr[idx] = temp[j++];
                continue;
            }

            if (j >= end) {
                arr[idx] = temp[i++];
                continue;
            }

            if (temp[i] < temp[j]) {
                arr[idx] = temp[i++];
            } else {
                arr[idx] = temp[j++];
            }
        }
    }
}
