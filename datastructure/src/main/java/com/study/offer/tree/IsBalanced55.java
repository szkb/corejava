package com.study.offer.tree;

/**
 * @author hangwu
 * @date 2020/9/11 9:36
 */
public class IsBalanced55 {

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left- right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
