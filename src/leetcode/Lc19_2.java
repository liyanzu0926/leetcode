package leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 代码改进版
 */


public class Lc19_2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个新结点当做头结点，这样删除head结点和删除任何一个结点操作相同
        ListNode headNode = new ListNode(0, head);
        ListNode p = head;
        ListNode q = headNode;
        for (int i = 0; i < n - 1; i++) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        headNode = headNode.next; //为什么不直接return head？因为head可能被删除了
        return headNode;
    }

    public static void main(String[] args) {

    }
}
