package leetcode;

public class Lc141 {
    public static void main(String[] args) {
    }
}

/**
 * 快慢指针
 */
class Solution141_1 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
