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

    @Test
    public void test() {

    }

}
