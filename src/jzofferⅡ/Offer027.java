package jzofferⅡ;

import leetcode.ListNode;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/23 11:21
 */
public class Offer027 {
}

class Solution027_1 {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMidNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        boolean res = isisPalindrome(l1, l2);
        recovery(mid, l2);
        return res;
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

    private boolean isisPalindrome(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private void recovery(ListNode mid, ListNode midNext) {
        midNext = reverse(midNext);
        mid.next = midNext;
    }
}

class Solution27_2 {
    ListNode left = null;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return check(head);
    }

    private boolean check(ListNode right) {
        if (right != null) {
            if (!check(right.next)) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
        }
        return true;
    }
}
