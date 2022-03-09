package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Lc142 {
    public static void main(String[] args) {

    }
}

/**
 * 哈希表
 */
class Solution142_1 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if (head == null || head.next == null) return null;
        while (head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }
        return set.contains(head) ? head : null;
    }
}

/**
 * 快慢指针
 * 设链表中环外部分的长度为 a，
 * slow 指针进入环后，又走了 b 的距离与 fast 相遇，
 * fast 指针已经走完了环的 nn 圈，因此它走过的总距离为
 * a + n(b + c) + b = a + (n + 1)b + nc。
 * fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
 * a + (n + 1)b + nc = 2(a + b) ⟹ a = c + (n − 1)(b + c)
 * 当n = 1时第一次相遇，得a = c.
 * 当相遇时，再用一个指针指向链表头部，让它和慢指针一次走一步，当相遇时即为环入口（因为a = c）
 */
class Solution142_2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast != slow) return null;
        ListNode p = head;
        while (p != slow){
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}