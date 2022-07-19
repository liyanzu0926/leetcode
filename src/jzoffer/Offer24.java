package jzoffer;

import leetcode.ListNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/19 9:58
 */
public class Offer24 {
}

class Solution24_1 {
    public ListNode reverseList(ListNode head) {
        ListNode headNode = new ListNode(-1);
        ListNode p = head;
        ListNode s = head;
        while (p != null) {
            s = p.next;
            p.next = headNode.next;
            headNode.next = p;
            p = s;
        }
        return headNode.next;
    }
}
