package niuke.top100;

import leetcode.ListNode;

/**
 * 插入排序
 */
public class BM12 {
    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode pre = headNode;
        ListNode r = head;
        ListNode p = head.next;
        head.next = null;
        ListNode s = null;
        while (p != null) {
            if (p.val >= r.val) {
                r.next = p;
                r = p;
                p = p.next;
                r.next = null;
            } else {
                s = p;
                p = p.next;
                while (pre.next.val <= s.val) {
                    pre = pre.next;
                }
                s.next = pre.next;
                pre.next = s;
                pre = headNode;
            }
        }
        return headNode.next;
    }
}

/**
 * 归并排序
 */
class BM12_2 {
    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortInList(head);
        ListNode right = sortInList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode headNode = new ListNode(-1);
        ListNode r = headNode;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                r.next = head1;
                r = head1;
                head1 = head1.next;
            } else {
                r.next = head2;
                r = head2;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            r.next = head1;
        } else if (head2 != null) {
            r.next = head2;
        }
        return headNode.next;
    }
}
