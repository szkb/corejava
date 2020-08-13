package com.study.offer.linklist;

/**
 * @author hangwu
 * @date 2020/8/10 8:19
 */
public class MergeLinkList {

    // 25
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        l1.next = node1;
        l2.next = node3;

        node1.next = node2;
        node3.next = node4;

        System.out.println(mergeTwoLists(l1, l2));
    }
}
