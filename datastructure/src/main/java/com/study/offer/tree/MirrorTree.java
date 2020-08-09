package com.study.offer.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hangwu
 * @date 2020/8/7 8:34
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode temp = first.left;
            first.left = first.right;
            first.right = temp;

            if (first.left != null) {
                queue.offer(first.left);
            }

            if (first.right != null) {
                queue.offer(first.right);
            }

        }
        return root;
    }
}
