package com.sc.alg.practise.common;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
        this.val = 4;
        this.left = new TreeNode(2);
        this.right  = new TreeNode(6);
        this.left.left = new TreeNode(1);
        this.left.right = new TreeNode(3);
        this.right.left = new TreeNode(5);
        this.right.right = new TreeNode(9);
    }

    public String toString() {
        return String.valueOf(val);
    }

    public void print() {
        // 层次遍历 bfs
        TreeNode current = this;
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