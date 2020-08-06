package com.study.offer.array.tree;

import org.junit.Test;

/*
* 解题要领：不会的要死磕，举例子去运行，不要怕。
*
* */

/**
 * @author hangwu
 * @date 2020/8/4 14:05
 */
public class ReconstructTree27 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int lengthA = preorder.length;
        int lengthB = inorder.length;

        // 这里不需要做重复操作了，一次构建就行了
        return recaculate(preorder, 0, lengthA - 1, inorder, 0, lengthB - 1);
    }

    private TreeNode recaculate(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int position = 0;
        TreeNode node = new TreeNode(preorder[preLeft]);
        // 这里应该是小于等于(j <= inRight)，容易出错
        for (int j = inLeft; j <= inRight; j++) {
            if (preorder[preLeft] == inorder[j]) {
                position = j;
                break;
            }
        }
        node.left = recaculate(preorder, preLeft + 1, preLeft + position - inLeft, inorder, inLeft, position - 1);
        node.right = recaculate(preorder, preLeft + position - inLeft + 1, preRight, inorder, position + 1, inRight);
        return node;
    }

    @Test
    public void test() {
        int[] preOrder = new int[]{1, 2, 4, 5, 3, 6};
        int[] inOrder = new int[]{4, 2, 5, 1, 3, 6};
        System.out.println(buildTree(preOrder, inOrder));
    }

}
