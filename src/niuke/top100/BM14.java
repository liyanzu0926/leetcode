package niuke.top100;

import leetcode.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM14 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNode = new ListNode(-1);
        ListNode r = headNode;
        ListNode p = head;
        ListNode s = null;
        int index = 2;
        while (p.next != null) {
            if (index % 2 == 0) {
                s = p.next;
                p.next = p.next.next;
                r.next = s;
                r = s;
                s.next = null;
                index++;
            } else {
                p = p.next;
                index++;
            }
        }
        p.next = headNode.next;
        return head;
    }
}
