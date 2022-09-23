package jzofferⅡ;

import leetcode.ListNode;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/23 9:41
 */
public class Offer024 {
}

class Solution024_1 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode headNode = new ListNode(-1, null);
        ListNode p = head;
        ListNode r = null;
        while (p != null) {
            r = p.next;
            p.next = headNode.next;
            headNode.next = p;
            p = r;
        }
        return headNode.next;
    }
}

class Solution024_2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
