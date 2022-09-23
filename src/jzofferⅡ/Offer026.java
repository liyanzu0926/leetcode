package jzofferⅡ;

import leetcode.ListNode;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/23 11:03
 */
public class Offer026 {
}

class Solution026_1 {
    public void reorderList(ListNode head) {
        ListNode mid = getMidNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        merge(l1, l2);
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode headNode = new ListNode(-1, null);
        ListNode r = null;
        while (head != null) {
            r = head.next;
            head.next = headNode.next;
            headNode.next = head;
            head = r;
        }
        return headNode.next;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l1.next = l2;
            l1 = next1;
            l2.next = l1;
            l2 = next2;
        }
    }
}
