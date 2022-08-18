package jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/18 11:27
 */
public class Offer59_1 {
}

class Solution59_1_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.getFirst() < nums[i]) {
                queue.pollFirst();
            }
            queue.offerFirst(nums[i]);
        }
        int[] res = new int[len - k + 1];
        res[0] = queue.getLast();
        for (int i = k; i < len; i++) {
            if (!queue.isEmpty() && nums[i - k] == queue.getLast()) {
                queue.pollLast();
            }
            while (!queue.isEmpty() && queue.getFirst() < nums[i]) {
                queue.pollFirst();
            }
            queue.offerFirst(nums[i]);
            res[i - k + 1] = queue.getLast();
        }
        return res;
    }
}
