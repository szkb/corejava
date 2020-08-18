package com.study.offer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hangwu
 * @date 2020/8/16 10:25
 */
public class MaxDepth36 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 一步步解析这个过程是最重要的，从繁至简
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
