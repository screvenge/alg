package com.sc.alg.practise.common;

public abstract class AlgUtil {

    public static int[] arr = {8, 4, 2, 9, 3, 0, 1, 6, 5, 7};

    public static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);

            if (i != arr.length - 1) {
                sb.append(',');
            }
        }

        System.out.println(sb);
    }

    public static void print(int[][] dp) {
        for (int[] ints : dp) {
            print(ints);
        }

        System.out.println();
    }
}
