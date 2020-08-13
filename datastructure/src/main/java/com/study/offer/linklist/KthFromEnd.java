package com.study.offer.linklist;

/**
 * @author hangwu
 * @date 2020/8/10 9:45
 */
public class KthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode headA = head;
        ListNode headB = head;

        while (--k >= 0) {
            headB = headB.next;
        }

        while (headA != null && headB != null) {
           headA = headA.next;
           headB = headB.next;
        }

        return headA;
    }
}
