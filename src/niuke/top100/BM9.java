package niuke.top100;

import leetcode.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class BM9 {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (--n > 0 && p.next != null) {
            p = p.next;
        }
        if (n != 0) {
            return null;
        }
        ListNode q = head;
        ListNode qPre = null;
        while (p.next != null) {
            qPre = q;
            q = q.next;
            p = p.next;
        }
        if (qPre == null) {
            head = head.next;
        } else {
            qPre.next = q.next;
        }
        return head;
    }
}
