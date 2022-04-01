package niuke.top100;

import leetcode.ListNode;

class BM16_1 {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        // 防止11223344这种情况
        while (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
            if (head == null || head.next == null) {
                return head;
            }
        }
        ListNode p = head;
        ListNode pre = head;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            if (q != null && q.val == p.val) {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                pre.next = q;
                p = q;
            } else {
                pre = p;
                p = q;
            }

        }
        return head;
    }
}

class BM16_2 {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode p = headNode;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int val = p.next.val;
                ListNode q = p.next.next.next;
                while (q != null && q.val == val) {
                    q = q.next;
                }
                p.next = q;
            } else {
                p = p.next;
            }
        }
        return headNode.next;
    }
}

/**
 * 递归
 */
class BM16_3 {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        if (curr.val == head.val) {
            while (curr != null && curr.val == head.val) {
                curr = curr.next;
            }
            head = deleteDuplicates(curr);
        } else {
            head.next = deleteDuplicates(curr);
        }
        return head;
    }
}