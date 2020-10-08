package com.sc.alg.practise;

import com.sc.alg.practise.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        // 要知道究竟是不是右节点, 引入prev辅助判断
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果是右节点或者没有右节点
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                // 右子树遍历
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
