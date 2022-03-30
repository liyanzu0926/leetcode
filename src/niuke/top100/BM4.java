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
public class BM4 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode headNode = new ListNode(-1);
        ListNode r = headNode;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                r = p;
                p = p.next;
            } else {
                r.next = q;
                r = q;
                q = q.next;
            }
        }
        if (p != null) {
            r.next = p;
        } else if (q != null) {
            r.next = q;
        }
        return headNode.next;
    }
}
