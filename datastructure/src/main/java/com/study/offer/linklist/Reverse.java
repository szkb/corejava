package com.study.offer.linklist;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/30 11:21
 */
public class Reverse {

    public ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode pre = null;
        ListNode cur = root;
        ListNode post;

        while (cur != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return pre;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        System.out.println(reverse(node1));
    }

}
