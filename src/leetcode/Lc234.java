package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Lc234 {
}

class Solution234_1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        Deque<Integer> stack = new LinkedList<>();
        int len = 0;
        ListNode p = head;
        while (p != null){
            len++;
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        for (int i = 0; i < len / 2; i++) {
            if (p.val != stack.remove()){
                return false;
            }
            p = p.next;
        }
        return true;
    }
}

/**
 * 快慢指针
 */
class Solution234_2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode halfNode = findHalfNode(head);
        ListNode secondHead = reverse(halfNode.next);
        ListNode p = head;
        ListNode q = secondHead;
        while (q != null){
            if (p.val != q.val){
                return false;
            }
            p = p.next;
            q = q.next;
        }
        halfNode.next = reverse(secondHead);
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode headNode = new ListNode(-1);
        ListNode r;
        while (head != null){
            r = head;
            head = head.next;
            r.next = headNode.next;
            headNode.next = r;
        }
        head = headNode.next;
        return head;
    }

    private ListNode findHalfNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next !=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
