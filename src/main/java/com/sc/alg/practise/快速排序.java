package com.sc.alg.practise;

import com.sc.alg.practise.common.AlgUtil;

public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = AlgUtil.arr;
        quickSort(arr);

        AlgUtil.print(arr);
    }

    /**
     * 快排的核心就是以第一个元素为基准, 先用end指针找出所有比基准元素小的元素, 再用start找出
     * 类似于反向归并
     * 1,4,2,5,3,0,1,7,8,9
     * 0,4,2,5,3,4,6,7,8,9
     * 0,1,2,5,3,4,6,7,8,9
     * 0,1,2,5,3,4,6,7,8,9
     * 0,1,2,4,3,4,6,7,8,9
     * 0,1,2,3,3,5,6,7,8,9
     * 0,1,2,3,4,5,6,7,8,9
     * 0,1,2,3,4,5,6,7,8,9
     *
     * @param arr 数组
     */
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = arr[start];
        int oldStart = start;
        int oldEnd = end;

        while (start < end) {
            // 从末尾开始找出第一个比基准元素小的元素
            while (arr[end] > temp && end > start) {
                end--;
            }

            // 没有比temp小的元素
            if (end == start) {
                break;
            }

            // 8,4,2,9,3,0,1,6,5,7变为
            // 7,4,2,9,3,0,1,6,5,7
            arr[start] = arr[end];

            // 再把第一个比最后一个元素大的元素扔到最后
            // 7,4,2,9,3,0,1,6,5,7变为
            // 7,4,2,9,3,0,1,6,5,9
            start++;
            while (arr[start] < temp && start < end) {
                start++;
            }

            if (start == end) {
                break;
            }

            arr[end] = arr[start];

            // 之后如此循环
        }

        // 此时start == end, 最后把temp换回来
        arr[start] = temp;
        AlgUtil.print(arr);

        // 继续快速排序扫描
        quickSort(arr, oldStart, start);
        quickSort(arr, start + 1, oldEnd);
    }
}
