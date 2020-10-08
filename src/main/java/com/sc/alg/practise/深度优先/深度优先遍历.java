package com.sc.alg.practise.深度优先;

import com.sc.alg.practise.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 深度优先遍历 {

    static  List<List<Integer>> ret = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        System.out.println(pathSum(new TreeNode(), 7));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        stack.push(root.val);
        // 从sum递减到0
        sum -= root.val;
        // 没有子节点了, 可以添加结果
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<>(stack));
        }
        // 有子节点就继续
        dfs(root.left, sum);
        dfs(root.right, sum);

        // 退出最后一个节点
        stack.pop();
    }
}
