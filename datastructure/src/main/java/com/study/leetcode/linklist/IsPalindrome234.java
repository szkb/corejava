package com.study.leetcode.linklist;

import com.study.offer.linklist.ListNode;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/10/23 9:44
 */
public class IsPalindrome234 {

    ListNode first;
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        first = head;
        return compare(head);
    }

    private boolean compare(ListNode head) {
        if (head.next != null) {
            compare(head.next);
        }

        if (head.val != first.val) {
            return false;
        }
        first = first.next;

        return first == null;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode last = new ListNode(1);
        head.next = second;
        second.next = third;
        third.next = last;
        System.out.println(isPalindrome(head));
    }
}
