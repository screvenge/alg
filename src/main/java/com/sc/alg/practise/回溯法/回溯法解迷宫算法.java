package com.sc.alg.practise.回溯法;

public class 回溯法解迷宫算法 {

    private static int len1;
    private static int len2;
    private static final int[][] migong = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0}};

    public static void main(String[] args) {
        // 判断迷宫是否能走通
        len1 = migong.length;
        len2 = migong[0].length;
        boolean[][] visit = new boolean[len1][len2];

        System.out.println(recursion(0, 0, visit));
    }

    private static boolean recursion(int i, int j, boolean[][] visit) {
        // 过滤掉越界或者已经访问过的情况
        if (i < 0 || j < 0 || i >= len1 || j >= len2 || visit[i][j] || migong[i][j] != 0) {
            return false;
        }

        // 走到最后一个点了, 通过
        if (i == len1 - 1 && j == len2 - 1) {
            return true;
        }

        visit[i][j] = true;

        boolean flag = recursion(i + 1, j, visit) || recursion(i, j + 1, visit) || recursion(i - 1, j, visit) ||
                recursion(i, j - 1, visit);

        // 走不通
        if (!flag) {
            visit[i][j] = false;
        }

        return flag;
    }
}
