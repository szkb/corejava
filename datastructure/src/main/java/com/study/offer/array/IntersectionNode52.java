package com.study.offer.array;

import com.study.offer.linklist.ListNode;

/**
 * @author hangwu
 * @date 2020/8/14 9:16
 */
public class IntersectionNode52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (headA.next != null && headB.next != null) {
            headA = headA.next;
            headB = headB.next;
        }

        while (headA != null) {
            nodeA = nodeA.next;
            headA = headA.next;
        }

        while (headB != null) {
            nodeB = nodeB.next;
            headB = headB.next;
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = (node1 == null) ? headB : node1.next;
            node2 = (node2 == null) ? headA : node2.next;
        }
        return node1;
    }
}
