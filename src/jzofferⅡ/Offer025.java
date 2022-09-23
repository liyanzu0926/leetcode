package jzofferⅡ;

import leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/23 10:16
 */
public class Offer025 {
}

class Solution025_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        ListNode p = l1;
        while (p != null) {
            stack1.push(p.val);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            stack2.push(p.val);
            p = p.next;
        }
        int carry = 0;
        ListNode headNode = new ListNode(-1, null);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + carry;
            int cur = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(cur, headNode.next);
            headNode.next = node;
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + carry;
            int cur = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(cur, headNode.next);
            headNode.next = node;
        }
        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + carry;
            int cur = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(cur, headNode.next);
            headNode.next = node;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry, headNode.next);
            headNode.next = node;
        }
        return headNode.next;
    }
}

class Solution025_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        ListNode p = l1;
        while (p != null) {
            stack1.push(p.val);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            stack2.push(p.val);
            p = p.next;
        }
        int carry = 0;
        ListNode headNode = new ListNode(-1, null);
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + carry;
            int cur = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(cur, headNode.next);
            headNode.next = node;
        }
        return headNode.next;
    }
}

