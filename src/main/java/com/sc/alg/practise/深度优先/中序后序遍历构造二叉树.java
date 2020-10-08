package com.sc.alg.practise.深度优先;

import com.sc.alg.practise.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 中序后序遍历构造二叉树 {
    int postIdx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode dfs(int inLeft, int inRight) {
        // 如果这里没有节点构造二叉树了，就结束
        if (inLeft > inRight) {
            return null;
        }

        // 选择 postIdx 位置的元素作为当前子树根节点
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        // 根据 root 所在位置分成左右两棵子树
        int index = idxMap.get(rootVal);

        // 下标减一，后序遍历的一定是右节点
        postIdx--;
        // 构造右子树
        root.right = dfs(index + 1, inRight);
        // 构造左子树
        root.left = dfs(inLeft, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        postIdx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idxMap.put(val, idx++);
        }

        return dfs(0, inorder.length - 1);
    }
}
