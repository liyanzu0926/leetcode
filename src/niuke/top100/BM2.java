package niuke.top100;

import leetcode.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class BM2 {
    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        int num = n - m + 1;
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode p = headNode;
        while (m-- > 1) {
            p = p.next;
        }
        ListNode q = p.next;
        p.next = null;
        ListNode r = null;
        while (num-- > 0) {
            r = q.next;
            q.next = p.next;
            p.next = q;
            q = r;
        }
        p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = r;
        return headNode.next;
    }
}
