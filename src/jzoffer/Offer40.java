package jzoffer;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/8 10:13
 */
public class Offer40 {
}

class Solution40_1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap.peek()) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}

class Solution40_2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quicksort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quicksort(int[] arr, int low, int high, int k) {
        if (low > high) {
            return;
        }
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < pivot) i++;
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = pivot;
        if (i == k - 1) {
            return;
        } else if (i < k - 1) {
            quicksort(arr, i + 1, high, k);
        } else {
            quicksort(arr, low, i - 1, k);
        }
    }
}
