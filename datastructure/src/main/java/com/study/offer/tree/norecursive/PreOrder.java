package com.study.offer.tree.norecursive;

import com.study.offer.tree.TreeNode;
import java.util.Stack;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/4 9:53
 */
public class PreOrder {

    public void noRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
