package niuke.top100;

import leetcode.ListNode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class BM5 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode headNode = new ListNode(-1);
        ListNode r = headNode;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.size(); i++) {
            ListNode node = lists.get(i);
            if (node != null) {
                heap.offer(node);
            }
        }
        while (!heap.isEmpty()) {
            ListNode p = heap.poll();
            r.next = p;
            r = p;
            if (p.next != null) {
                p = p.next;
                heap.offer(p);
            }
        }
        return headNode.next;
    }
}
