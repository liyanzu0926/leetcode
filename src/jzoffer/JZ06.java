package jzoffer;

import leetcode.ListNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/5/31 12:24
 */
public class JZ06 {
}

/**
 * @Description: 头插法
 * @author: lww
 * @date: 2022/5/31 12:25
 */
class Solution06_1 {
    // 头插法
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        head = null;
        ListNode s = null;
        int count = 0;
        while (p != null) {
            s = p;
            p = p.next;
            s.next = head;
            head = s;
            count++;
        }
        int[] res = new int[count];
        int i = 0;
        while (head != null) {
            res[i++] = head.val;
            head = head.next;
        }
        return res;
    }
}

/**
 * @Description: 先遍历一边链表获取链表长度，在遍历一遍链表，从数组尾部开始赋值
 * @author: lww
 * @date: 2022/5/31 12:25
 */
class Solution06_2 {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        int[] res = new int[count];
        p = head;
        while (p != null) {
            res[count - 1] = p.val;
            p = p.next;
            count--;
        }
        return res;
    }
}

/**
 * @Description: 栈
 * @author: lww
 * @date: 2022/5/31 12:31
 */


