package leetcode;

public class LinkedListUtils {
    /**
     * 尾插法创建无头结点的单链表
     * @param head
     * @return
     */
    public static ListNode createSingleLinkedListByTailInsert(int[] head){
        if (head.length == 0) return null;
        ListNode headNode = new ListNode();
        ListNode r = headNode;
        for (int i = 0; i < head.length; i++) {
            r.next = new ListNode(head[i]);
            r = r.next;
        }
        headNode = headNode.next;
        return headNode;
    }
}
