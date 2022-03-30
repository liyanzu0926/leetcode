
import leetcode.LinkedListUtils;
import leetcode.ListNode;
import niuke.top100.BM2;
import niuke.top100.BM3;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = LinkedListUtils.createSingleLinkedListByTailInsert(nums);
        ListNode node = new BM3().reverseKGroup(head, k);
    }
}