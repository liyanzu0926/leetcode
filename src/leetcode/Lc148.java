package leetcode;

public class Lc148 {
    public static void main(String[] args) {
        int[] head = {4, 2, 1, 3};
        ListNode headNode = LinkedListUtils.createSingleLinkedListByTailInsert(head);
        ListNode node = new Solution148_2().sortList(headNode);
    }
}

/**
 * 插入排序
 */
class Solution148_1 {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode p = head.next;
        head.next = null;
        ListNode r = head;
        ListNode pre = null;
        ListNode s;
        while (p != null) {
            while (r != null && r.val < p.val) {
                pre = r;
                r = r.next;
            }
            s = p;
            p = p.next;
            if (r == head) {
                s.next = head;
                head = s;
            } else {
                s.next = r;
                pre.next = s;
            }
            pre = null;
            r = head;
        }
        return head;
    }
}

/**
 * 归并排序
 */
class Solution148_2 {
    public ListNode sortList(ListNode head) {
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
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode headNode = new ListNode(-1);
        ListNode r = headNode;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                r.next = left;
                left = left.next;
            } else {
                r.next = right;
                right = right.next;
            }
            r = r.next;
        }
        if (left != null) {
            r.next = left;
        } else if (right != null){
            r.next = right;
        }
        return headNode.next;
    }
}
