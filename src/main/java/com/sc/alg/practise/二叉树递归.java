package com.sc.alg.practise;

import com.sc.alg.practise.common.TreeNode;

public class 二叉树递归 {
    public static void main(String[] args) {
        TreeNode result = 二叉树求和(new TreeNode());
        result.print();

    }

    public static TreeNode 二叉树翻转(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode left = 二叉树翻转(treeNode.left);
        treeNode.left = 二叉树翻转(treeNode.right);
        treeNode.right = left;
        return treeNode;
    }

    public static TreeNode 二叉树求和(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode left = 二叉树求和(treeNode.left);
        TreeNode right = 二叉树求和(treeNode.right);
        treeNode.val = treeNode.val + (left == null ? 0 : left.val)  + (right == null ? 0 : right.val);
        return treeNode;
    }
}
