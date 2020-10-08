package com.sc.alg.practise.common;

public abstract class AlgUtil {

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
}
