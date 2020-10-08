package com.sc.alg.practise;

import com.sc.alg.practise.common.TreeNode;

public class 分而治之监视器 {
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    /**
     * 状态 0：root必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
     * 状态 1：覆盖整棵树需要的摄像头数目，无论root是否放置摄像头。
     * 状态 2：覆盖两棵子树需要的摄像头数目，root可能无法监视。
     * 0 = l1 + r1 + 1
     * 1 = min(l1 + r1 + 1, min(l1 + r2, l2 + r1) )
     */
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }
}
