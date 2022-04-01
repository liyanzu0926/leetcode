package niuke.top100;

import leetcode.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class BM13 {
    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            int n1 = list.get(i);
            int n2 = list.get(list.size() - 1 - i);
            if (n1 != n2) {
                return false;
            }
        }
        return true;
    }
}
