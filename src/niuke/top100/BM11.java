package niuke.top100;

import leetcode.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class BM11 {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode headNode = new ListNode(-1);
        int currVal = 0;
        int carry = 0;
        while (head1 != null && head2 != null) {
            int val = head1.val + head2.val + carry;
            currVal = val % 10;
            carry = val / 10;
            head1 = head1.next;
            head2 = head2.next;
            ListNode s = new ListNode(currVal);
            s.next = headNode.next;
            headNode.next = s;
        }
        while (head1 != null) {
            int val = head1.val + carry;
            currVal = val % 10;
            carry = val / 10;
            head1 = head1.next;
            ListNode s = new ListNode(currVal);
            s.next = headNode.next;
            headNode.next = s;
        }
        while (head2 != null) {
            int val = head2.val + carry;
            currVal = val % 10;
            carry = val / 10;
            head2 = head2.next;
            ListNode s = new ListNode(currVal);
            s.next = headNode.next;
            headNode.next = s;
        }
        if (carry != 0) {
            ListNode s = new ListNode(carry);
            s.next = headNode.next;
            headNode.next = s;
        }
        return headNode.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode headNode = new ListNode(-1);
        ListNode r = null;
        while (head != null) {
            r = head.next;
            head.next = headNode.next;
            headNode.next = head;
            head = r;
        }
        return headNode.next;
    }
}
