package jzoffer;

import leetcode.ListNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/19 10:07
 */
public class Offer25 {
}

class Solution25_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode pnext = null;
        ListNode qnext = null;
        ListNode head = new ListNode(-1);
        ListNode r = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                pnext = p.next;
                r.next = p;
                r = p;
                p.next = null;
                p = pnext;
            } else {
                qnext = q.next;
                r.next = q;
                r = q;
                q.next = null;
                q = qnext;
            }
        }
        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        return head.next;
    }
}

class Solution25_2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode r = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }
        if (l1 != null) {
            r.next = l1;
        }
        if (l2 != null) {
            r.next = l2;
        }
        return head.next;
    }
}
