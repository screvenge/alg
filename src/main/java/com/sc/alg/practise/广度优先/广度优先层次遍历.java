package com.sc.alg.practise.广度优先;

import com.sc.alg.practise.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 广度优先层次遍历 {
    public static void main(String[] args) {

    }

    public static void print(TreeNode current) {
        // 层次遍历 bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(current);
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            //  queue相当于所有上一层元素的所有队列
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        System.out.println(list);
    }
}
