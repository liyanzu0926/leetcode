package niuke.top100;

import leetcode.ListNode;

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class BM7 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        if (pHead.next == pHead) {
            return pHead;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return null;
        }
        ListNode p = pHead;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}
