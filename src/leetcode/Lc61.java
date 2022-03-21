package leetcode;

public class Lc61 {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        ListNode head = LinkedListUtils.createSingleLinkedListByTailInsert(list);
        ListNode node = new Solution61_1().rotateRight(head, 2);
    }
}

class Solution61_1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode p = head;
        int i = 1;
        while (p.next != null) {
            i++;
            p = p.next;
        }
        p.next = head;
        int j = i - k % i;
        while (j > 0) {
            p = p.next;
            j--;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
