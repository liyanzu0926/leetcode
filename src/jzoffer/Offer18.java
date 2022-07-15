package jzoffer;

import leetcode.ListNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/15 9:53
 */
public class Offer18 {
}

class Solution18_1 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            head = head.next;
        }
        ListNode p = head;
        while (p.next != null && p.next.val != val) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        return head;
    }
}
