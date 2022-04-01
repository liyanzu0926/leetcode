
import leetcode.LinkedListUtils;
import leetcode.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        // list转数组
        Integer[] array = list.toArray(new Integer[list.size()]);

        // 数组转list
        List<Integer> list1 = Arrays.asList(array);
    }
}