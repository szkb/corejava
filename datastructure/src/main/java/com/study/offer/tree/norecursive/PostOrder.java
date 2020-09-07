package com.study.offer.tree.norecursive;

import com.study.offer.tree.TreeNode;
import java.util.Stack;

/**
 * @author hangwu
 * @date 2020/9/7 19:10
 */
public class PostOrder {

    /**
     *
     * 后序遍历是左右根，那么堆栈中应该是根右左，那么第一个栈则是左右，先弹出根。
     *
     * @param head 根节点
     */
    public static void posOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
    }
}
