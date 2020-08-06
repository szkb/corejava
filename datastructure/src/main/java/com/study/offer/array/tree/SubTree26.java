package com.study.offer.array.tree;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/6 9:17
 */
public class SubTree26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        List<Integer> treeNodeAToArray = transfer(A, new ArrayList<>());
        List<Integer> treeNodeBToArray = transfer(B, new ArrayList<>());

        int i = 0;
        int j = 0;

        while (i < treeNodeAToArray.size() && j < treeNodeBToArray.size()) {
            if (treeNodeAToArray.get(i).equals(treeNodeBToArray.get(j))) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == treeNodeBToArray.size();

    }

    private List<Integer> transfer(TreeNode a, List<Integer> number) {
        // 递归表达式需要有边界条件
        if (a == null) {
            return number;
        }
        number.add(a.val);
        transfer(a.left, number);
        transfer(a.right, number);
        return number;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(-4);
        TreeNode node4 = new TreeNode(-3);
        node.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(-4);
        node5.left = node6;
        System.out.println(subStructure(node, node5));

    }

    public boolean subStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return traverse(A, B.val, B);

    }

    private boolean traverse(TreeNode a, int number, TreeNode b) {
        // 递归表达式需要有边界条件
        if (a.val == number) {
            return compare(a, b);
        }
        if (a.left != null) {
            return traverse(a.left, number, b);
        }
        if (a.right != null) {
            return traverse(a.right, number, b);
        }
        return false;
    }

    private boolean compare(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a.val != b.val) {
            return false;
        }
        boolean left = compare(a.left, b.left);
        boolean right = compare(a.right, b.right);

        return left && right;
    }

    public boolean isReallySubStructure(TreeNode A, TreeNode B) {

        // 如果A或B都走完了还没找到，那应该就是找不到了
        if (A == null || B == null) {
            return false;
        }

        //看看当前节点成不？不成就看看左边，不然看看右边？
        return s(A, B) || isReallySubStructure(A.left, B) || isReallySubStructure(A.right, B);
    }


    boolean s(TreeNode a, TreeNode b) {
        // b这边都看完了，还没挑出不同？那就是了吧！
        if (b == null) {
            return true;
        }
        // b这边还没看完了，a那边就null了？
        else if (a == null) {
            return false;
        }

        return a.val == b.val && s(a.left, b.left) && s(a.right, b.right);
    }

}
