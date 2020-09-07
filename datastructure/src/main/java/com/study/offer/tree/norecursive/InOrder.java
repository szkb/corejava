package com.study.offer.tree.norecursive;

import com.study.offer.tree.TreeNode;
import java.util.Stack;

/**
 * @author hangwu
 * @date 2020/9/7 19:05
 */
public class InOrder {

    public static void inOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }
}
