package niuke.top100;

import leetcode.ListNode;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class BM10 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p = pHead1;
        int len1 = 0;
        while (p != null) {
            len1++;
            p = p.next;
        }
        int len2 = 0;
        p = pHead2;
        while (p != null) {
            len2++;
            p = p.next;
        }
        ListNode head1 = null;
        ListNode head2 = null;
        int m = 0;
        if (len1 > len2) {
            head1 = pHead1;
            head2 = pHead2;
            m = len1 - len2;
        } else {
            head1 = pHead2;
            head2 = pHead1;
            m = len2 - len1;
        }

        while (m-- > 0) {
            head1 = head1.next;
        }
        while (head1 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}
