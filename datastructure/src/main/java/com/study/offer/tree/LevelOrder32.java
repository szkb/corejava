package com.study.offer.tree;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/24 8:50
 */
public class LevelOrder32 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> treeNodeQueues = new LinkedList<>();
        treeNodeQueues.offer(root);

        int[] sequence = new int[1024];
        int k = 0;
        sequence[k++] = root.val;

        while (!treeNodeQueues.isEmpty()) {
            root = treeNodeQueues.poll();
            if (root.left != null) {
                treeNodeQueues.offer(root.left);
                sequence[k++] = root.left.val;
            }
            if (root.right != null) {
                treeNodeQueues.offer(root.right);
                sequence[k++] = root.right.val;
            }
        }

        return Arrays.copyOfRange(sequence, 0, k);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        System.out.println(Arrays.toString(levelOrder(node1)));
    }
}
