package jzofferⅡ;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/22 10:47
 */
public class Offer022 {
}

/**
 * @Description: 快慢指针
 * @author: lyz
 * @date: 2022/9/22 10:48
 */
class Solution022_1 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }
}

class Solution022_2 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            } else {
                set.add(p);
            }
            p = p.next;
        }
        return null;
    }
}
