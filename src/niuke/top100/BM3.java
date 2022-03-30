package niuke.top100;

import leetcode.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class BM3 {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        n = n / k;
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        p = headNode;

        while (n-- > 0) {
            p = reverse(p, k);
        }
        return headNode.next;
    }

    private ListNode reverse(ListNode p, int k) {
        ListNode q = p.next;
        p.next = null;
        while (k-- > 0) {
            ListNode r = q.next;
            q.next = p.next;
            p.next = q;
            q = r;
        }
        while (p.next != null) {
            p = p.next;
        }
        p.next = q;
        return p;
    }
}
