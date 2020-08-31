package com.study.offer.tree;

import java.util.*;

/**
 * @author hangwu
 * @date 2020/8/25 9:54
 */
public class LevelOrder32II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> treeNodeQueues = new LinkedList<>();
        treeNodeQueues.offer(root);

        List<List<Integer>> ans = new ArrayList<>();

        while (!treeNodeQueues.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            for (int i = treeNodeQueues.size(); i > 0; i--) {
                root = treeNodeQueues.poll();
                temp.add(root.val);
                if (root.left != null) {
                    treeNodeQueues.offer(root.left);
                }
                if (root.right != null) {
                    treeNodeQueues.add(root.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
