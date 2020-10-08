package com.sc.alg.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 格雷编码 {
    public static void main(String[] args) {
        grayCode(2);
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }

            // head往右位移一位
            head <<= 1;
        }
        return res;
    }
}
