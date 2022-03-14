package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lc253 {
    public static void main(String[] args) {
        int[][] intervals = {{7, 10}, {2, 4}};
        System.out.println(new Solution253_1().minMeetingRooms(intervals));
    }
}

class Solution253_1 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1) return 1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int least = 0;
        for (int i = 0; i < intervals.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= intervals[i][0]) {
                heap.poll();
            }
            heap.offer(intervals[i][1]);
            least = Math.max(least, heap.size());
        }
        return least;
    }
}
