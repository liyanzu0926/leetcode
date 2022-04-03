package niuke.top100;

import java.util.*;

class BM47_1 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < n; i++) {
            heap.offer(a[i]);
        }
        int res = -1;
        for (int i = 0; i < K; i++) {
            res = heap.poll();
        }
        return res;
    }
}
