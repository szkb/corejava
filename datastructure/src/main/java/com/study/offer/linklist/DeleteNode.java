package com.study.offer.linklist;

/**
 * @author hangwu
 * @date 2020/8/15 14:08
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
                return head;
            }
            q = q.next;
            p = p.next;
        }
        return head;
    }
}
