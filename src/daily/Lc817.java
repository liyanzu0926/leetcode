package daily;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/12 9:46
 */
public class Lc817 {
}

class Solution817_1 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode p = head;
        ListNode pre = null;
        int count = 0;
        while (p != null) {
            // 如果前一个结点不在nums中，且当前结点在nums中，说明当前结点是起始点
            // 则count++
            if (set.contains(p.val) && (pre == null || !set.contains(pre.val))) {
                count++;
            }
            pre = p;
            p = p.next;
        }
        return count;
    }
}

class Solution817_2 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode p = head;
        int res = 0;
        int addend = 1;
        while (p != null) {
            if (set.contains(p.val)) {
                res += addend;
                addend = 0;
            } else {
                addend = 1;
            }
            p = p.next;
        }
        return res;
    }
}
