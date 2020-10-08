package com.sc.alg.practise.深度优先;

import com.sc.alg.practise.common.TreeNode;

public class 深度优先搜索之和 {

    public static void main(String[] args) {
        深度优先搜索之和 s = new 深度优先搜索之和();
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
