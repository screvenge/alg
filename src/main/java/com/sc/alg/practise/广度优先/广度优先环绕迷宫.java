package com.sc.alg.practise.广度优先;

import java.util.LinkedList;
import java.util.Queue;

public class 广度优先环绕迷宫 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;

        // int[]就相当于坐标
        // queue用于添加所有边缘的坐标
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
            }
        }
        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new int[]{0, j});
            }
            if (board[n - 1][j] == 'O') {
                queue.offer(new int[]{n - 1, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            board[x][y] = 'A';
            // 4相当于上下左右
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
