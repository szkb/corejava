package com.study.offer.tree;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/18 20:38
 */
public class PathSum34 {
    LinkedList<LinkedList<TreeNode>> ans = new LinkedList<>();
    LinkedList<TreeNode> path = new LinkedList<>();

    public LinkedList<LinkedList<TreeNode>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new LinkedList<>();
        }

        recur(root, sum);
        return ans;
    }

    private void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root);
        sum = sum - root.val;

        if (sum == 0 && root.left == null && root.right == null) {
            ans.add(path);
        }

        recur(root.left, sum);
        recur(root.right, sum);
        path.removeLast();

    }

    public boolean exist(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        int temp = sum - root.val;
        if (temp == 0 && root.left == null && root.right == null) {
            return true;
        }

        return exist(root.left, temp) || exist(root.right, temp);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node5.right = node7;
        node3.right = node8;

        System.out.println(pathSum(node1, 18));
    }

}
