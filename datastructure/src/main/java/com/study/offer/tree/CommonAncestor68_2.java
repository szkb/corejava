package com.study.offer.tree;

import java.util.LinkedList;
import java.util.Stack;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/7 9:33
 */
public class CommonAncestor68_2 {

    private Stack<TreeNode> firstStack = new Stack<>();
    private Stack<TreeNode> secondStack = new Stack<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        LinkedList<TreeNode> first = new LinkedList<>();
        LinkedList<TreeNode> second = new LinkedList<>();

        visit(root, p, first, q, second);

        firstStack.retainAll(secondStack);
        return firstStack.pop();
    }

    private void visit(TreeNode root, TreeNode p, LinkedList<TreeNode> first, TreeNode q, LinkedList<TreeNode> second) {
        if (root.val == p.val) {
            pushValueToStack(firstStack, first);
        }

        if (root.val == q.val) {
            pushValueToStack(secondStack, second);
        }
        first.add(root);
        second.add(root);
        if (root.left != null) {
            visit(root.left, p, first, q, second);
        }
        if (root.right != null) {
            visit(root.right, p, first, q, second);
        }
    }

    private void pushValueToStack(Stack<TreeNode> firstStack, LinkedList<TreeNode> first) {
        while (!first.isEmpty()) {
            firstStack.push(first.poll());
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        System.out.println(lowestCommonAncestor2(node3, node2, node0).val);
    }
}
