package jzoffer;

import leetcode.ListNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/19 9:53
 */
public class Offer22 {
}

class Solution22_1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 1;
        ListNode p = head;
        ListNode q = head;
        while (p.next != null && count != k) {
            count++;
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
