package jzofferⅡ;

import leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/22 9:44
 */
public class Offer021 {
}

/**
 * @Description: 双指针
 * @author: lyz
 * @date: 2022/9/22 10:00
 */
class Solution021_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(-1, head);
        ListNode first = headNode;
        ListNode second = headNode;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return headNode.next;
    }
}

/**
 * @Description: 栈
 * @author: lyz
 * @date: 2022/9/22 10:07
 */
class Solution021_2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(-1, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p = headNode;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while ((n--) != 0) {
            stack.pop();
        }
        p = stack.peek();
        p.next = p.next.next;
        return headNode.next;
    }
}
