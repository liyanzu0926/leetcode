package leetcode;

import java.util.*;

public class Lc347 {
    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(Arrays.toString(new Solution347_2().topKFrequent(nums, 2)));
    }
}

/**
 * 优先队列
 */
class Solution347_1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            int key = next.getKey();
            int val = next.getValue();
            if (heap.size() < k) {
                heap.offer(new int[]{key, val});
                continue;
            }
            if (heap.peek()[1] < val) {
                heap.poll();
                heap.offer(new int[]{key, val});
            }
        }
        int[] ans = new int[k];
        int index = 0;
        Iterator<int[]> heapIterator = heap.iterator();
        while (heapIterator.hasNext()) {
            ans[index++] = heapIterator.next()[0];
        }
        return ans;
    }
}

/**
 * 快速排序
 */
class Solution347_2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        quickSort(list, 0, list.size() - 1, k, ans);
        return ans;
    }

    public void quickSort(List<int[]> list, int low, int high, int target, int[] ans) {
        int i = low;
        int j = high;
        int[] pivot = list.get(low);
        if (i > j) return;
        while (i < j) {
            while (i < j && list.get(j)[1] < pivot[1]) j--;
            if (i < j) {
                list.set(i,list.get(j));
                i++;
            }
            while (i < j && list.get(i)[1] >= pivot[1]) i++;
            if (i < j) {
                list.set(j,list.get(i));
                j--;
            }
        }
        list.set(i, pivot);
        if (i + 1 == target) {
            for (int x = 0; x < target; x++) {
                ans[x] = list.get(x)[0];
            }
            return;
        } else if (i + 1 < target) {
            quickSort(list, i + 1, high, target, ans);
        } else {
            quickSort(list, low, i - 1, target, ans);
        }
    }
}
