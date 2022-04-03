package niuke.top100;

import java.util.*;

public class BM45 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.getLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
        }
        res.add(num[queue.getFirst()]);
        for (int i = size; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.getLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            while (!queue.isEmpty() && queue.getFirst() < i - size + 1) {
                queue.pollFirst();
            }
            res.add(num[queue.getFirst()]);
        }
        return res;
    }
}
