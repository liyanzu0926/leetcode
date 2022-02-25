package leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 思想：快慢指针
 * 想要删除链表中的某个结点，需要找到它的前一个结点。
 * 定义两个指针，当前一个指针走n + 1步时，再让后一个指针走，
 * 这样当前一个指针走到末尾时后一个指针刚好是要删除结点的前一个结点
 */


public class Lc19_1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) { //如果链表中只有一个结点，删除后为null
            return head = null;
        }
        ListNode p = null;
        ListNode q = null;
        int count = 0;
        while (p == null || p.next != null) {
            if (p == null) {
                p = head;
            } else {
                p = p.next;
            }
            count++;
            if (count > n) {
                if (q == null) {
                    q = head;
                } else {
                    q = q.next;
                }
            }
        }
        if (q == null) { //要删除的结点为头结点
            head = head.next;
            return head;
        }
        q.next = q.next.next;  //删除倒数第n个结点
        return head;
    }

    public static void main(String[] args) {

    }
}
