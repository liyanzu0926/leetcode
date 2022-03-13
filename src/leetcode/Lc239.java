package leetcode;


import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc239 {
}

class Solution239_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return new int[]{nums[0]};
        int[] answer = new int[len - k + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>
                ((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < k; i++) {
            heap.offer(new int[]{nums[i], i});
        }
        answer[0] = heap.peek()[0];
        for (int i = k; i < len; i++) {
            heap.offer(new int[]{nums[i], i});
            while (heap.peek()[1] <= i - k){
                heap.poll();
            }
            answer[i - k + 1] = heap.peek()[0];
        }
        return answer;
    }
}

/**
 * 单调队列
 */
class Solution239_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return new int[]{nums[0]};
        int[] answer = new int[len - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        answer[0] = nums[queue.getFirst()];
        for (int i = k; i < len; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while (queue.getFirst() <= i - k){
                queue.pollFirst();
            }
            answer[i - k + 1] = nums[queue.getFirst()];
        }
        return answer;
    }
}
