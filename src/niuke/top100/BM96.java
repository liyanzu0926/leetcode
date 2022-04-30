package niuke.top100;

import java.util.*;

public class BM96 {

    public int minmumNumberOfHost(int n, int[][] startEnd) {
        //Arrays.sort(startEnd, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(startEnd, (a, b) -> a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : (a[0] < b[0] ? -1 : 1));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(startEnd[0][1]);
        for (int i = 1; i < n; i++) {
            if (startEnd[i][0] >= heap.peek()) {
                heap.poll();
            }
            heap.offer(startEnd[i][1]);
        }
        return heap.size();
    }
}
