package com.sc.alg.practise.深度优先;

import com.sc.alg.practise.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 深度优先中序遍历 {
    public List<Integer>  inOrder(TreeNode current) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 此时current为null，pop出它的父节点
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }
}
