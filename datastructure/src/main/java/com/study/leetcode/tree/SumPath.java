package com.study.leetcode.tree;

import com.study.offer.tree.TreeNode;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/10/29 11:43
 */
public class SumPath {

    LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public int sumNumbers(TreeNode root) {
        getSumPath(root);
        int sum = 0;
        for (LinkedList<Integer> item : ans) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer number : item) {
                stringBuilder.append(number);
            }

            sum += Integer.parseInt(stringBuilder.toString());

        }
        return sum;
    }

    private void getSumPath(TreeNode root) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(new LinkedList<>(path));
        }
        getSumPath(root.left);
        getSumPath(root.right);
        path.removeLast();
    }

    @Test
    public void test() {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);

        System.out.println(StringUtils.join(ans));
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(sumNumbers(node1));
    }
}
