package com.sc.alg.practise;

import com.sc.alg.practise.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class 分而治之构造二叉树 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int mid = start; mid <= end; mid++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, mid - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(mid + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            // 有 left * right种可能性
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(mid);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
