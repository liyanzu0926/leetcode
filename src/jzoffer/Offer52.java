package jzoffer;

import leetcode.ListNode;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/15 11:03
 */
public class Offer52 {
}

class Solution52_1 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }
        pA = headA;
        pB = headB;
        int gap = lenA - lenB;
        // 让pA始终指向较长的那个链表
        if (lenB > lenA) {
            pA = headB;
            pB = headA;
            gap = lenB - lenA;
        }
        while (gap > 0) {
            pA = pA.next;
            gap--;
        }
        while (pA != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}

class Solution52_2 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
