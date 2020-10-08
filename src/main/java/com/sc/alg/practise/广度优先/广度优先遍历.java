package com.sc.alg.practise.广度优先;

import com.sc.alg.practise.common.TreeNode;

import java.util.*;

public class 广度优先遍历 {
    static List<List<Integer>> ret = new LinkedList<>();
    static Map<TreeNode, TreeNode> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(pathSum(new TreeNode(), 7));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        // sumQueue用来记录路径总和, 减少遍历的消耗
        // nodeQueue和sumQueue是同步入队出队的, 可以视为是对TreeNode的封装
        nodeQueue.offer(root);
        sumQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int result = sumQueue.poll() + node.val;

            // 没有子节点
            if (node.left == null && node.right == null) {
                if (result == sum) {
                    getPath(node);
                }
            } else {

                // map维护key与父节点的关系
                if (node.left != null) {
                    map.put(node.left, node);
                    nodeQueue.offer(node.left);
                    sumQueue.offer(result);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    nodeQueue.offer(node.right);
                    sumQueue.offer(result);
                }
            }
        }

        return ret;
    }

    public static void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<>(temp));
    }
}