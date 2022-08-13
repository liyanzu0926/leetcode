package jzoffer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/13 11:20
 */
public class Offer49 {
}

class Solution49_1 {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int[] factor = {2, 3, 5};
        long ugly = 1L;
        for (int i = 0; i < n; i++) {
            ugly = heap.poll();
            for (int fac : factor) {
                long nextUgly = ugly * fac;
                if (set.add(nextUgly)) {
                    heap.offer(nextUgly);
                }
            }
        }
        return (int) ugly;
    }
}

class Solution49_2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 指针2，3，5值表示下标
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            int ugly = Math.min(Math.min(num2, num3), num5);
            dp[i] = ugly;
            if (ugly == num2) {
                p2++;
            }
            if (ugly == num3) {
                p3++;
            }
            if (ugly == num5) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}
