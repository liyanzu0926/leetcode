package leetcode;

/**
 * 21. 合并两个有序链表
 */


public class Lc21_1 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        l2 = null;
        l1 = null;
        ListNode newListNode = new ListNode(0, null);
        ListNode s = null;
        ListNode r = newListNode;
        while (p != null && q != null) {
            if (p.val < q.val) {
                s = p.next;
                r.next = p;
                p = s;
                r = r.next;
            } else {
                s = q.next;
                r.next = q;
                q = s;
                r = r.next;
            }
        }
        if (p != null) r.next = p;
        if (q != null) r.next = q;
        newListNode = newListNode.next;
        return newListNode;
    }

    public static void main(String[] args) {

    }
}
