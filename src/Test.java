
import leetcode.LinkedListUtils;
import leetcode.ListNode;
import leetcode.TreeNode;
import leetcode.TreeUtils;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Test {
    public static void main(String[] args) {
        Integer[] nums = {5,4,null,3,null,2};
        TreeNode tree = TreeUtils.createTreeBylevelOrder(nums);
    }
}