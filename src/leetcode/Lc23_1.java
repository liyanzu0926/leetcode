package leetcode;

/**
 * 23. 合并K个升序链表
 */
public class Lc23_1 {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode headNode = new ListNode();
        ListNode r = headNode;
        ListNode minp = null;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (true) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if (index == -1) break; //说明所有链表都已为空，跳出循环
            r.next = lists[index];
            r = r.next;
            lists[index] = lists[index].next;
            index = -1;
            min = Integer.MAX_VALUE;
        }
        headNode = headNode.next;
        return headNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5, null);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);

        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode5 = new ListNode(3, listNode4);
        ListNode listNode6 = new ListNode(1, listNode5);

        ListNode listNode7 = new ListNode(6, null);
        ListNode listNode8 = new ListNode(2, listNode7);

        ListNode[] list = {listNode3, listNode6, listNode8};
        ListNode listNode = mergeKLists(list);
        System.out.println(listNode);
    }
}
