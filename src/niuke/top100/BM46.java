package niuke.top100;

import java.util.*;

class BM46_1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            heap.offer(input[i]);
        }
        for (int i = 0; i < k; i++) {
            res.add(heap.poll());
        }
        return res;
    }
}

class BM46_2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int low = 0;
        int high = input.length - 1;
        while (low < high) {
            int i = low;
            int j = high;
            int pivot = input[i];
            while (i < j) {
                while (i < j && input[j] > pivot) j--;
                if (i < j) {
                    input[i++] = input[j];
                }
                while (i < j && input[i] <= pivot) i++;
                if (i < j) {
                    input[j--] = input[i];
                }
            }
            input[i] = pivot;
            if (i == k) {
                break;
            } else if (i < k) {
                low = i + 1;
            } else {
                high = i - 1;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
}
