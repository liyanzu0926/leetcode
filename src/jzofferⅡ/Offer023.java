package jzofferⅡ;

import leetcode.ListNode;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/22 11:27
 */
public class Offer023 {
}

class Solution023_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        ListNode pB = headB;
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }
        int gap = 0;
        if (lenB > lenA) {
            pA = headB;
            pB = headA;
            gap = lenB - lenA;
        } else {
            pA = headA;
            pB = headB;
            gap = lenA - lenB;
        }
        while (gap != 0) {
            pA = pA.next;
            gap--;
        }
        while (pA != null && pB != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
