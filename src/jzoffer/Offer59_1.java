package jzoffer;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

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

class Solution59_1_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : b[0] - a[0];
            }
        });
        for (int i = 0; i < k; i++) {
            heap.offer(new int[]{nums[i], i});
        }
        int[] res = new int[len - k + 1];
        res[0] = heap.peek()[0];
        for (int i = k; i < len; i++) {
            heap.offer(new int[]{nums[i], i});
            while (heap.peek()[1] <= i - k) {
                heap.poll();
            }
            res[i - k + 1] = heap.peek()[0];
        }
        return res;
    }
}
