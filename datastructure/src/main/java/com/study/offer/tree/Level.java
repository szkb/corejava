package com.study.offer.tree;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/28 15:37
 */
public class Level {

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeNode last = null;
            for (int i = 1; i <= n; ++i) {
                TreeNode f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }

    @Test
    public void test() {
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(new TreeNode(1));
        s1.push(new TreeNode(2));
        s1.push(new TreeNode(3));

        while (!s1.isEmpty()) {
            System.out.println(s1.pop().val);
        }
    }
}
