package leetcode;

public class Lc206 {
}

class Solution206_1 {
    public ListNode reverseList(ListNode head) {
        ListNode headNode = new ListNode(-1);
        ListNode s;
        while (head != null){
            s = head;
            head = head.next;
            s.next = headNode.next;
            headNode.next = s;
        }
        head = headNode.next;
        return head;
    }
}
