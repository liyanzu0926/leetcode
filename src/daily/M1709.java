package daily;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/28 10:04
 */
public class M1709 {
}

class Solution1709_1 {
    public int getKthMagicNumber(int k) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        int[] factor = {3, 5, 7};
        set.add(1L);
        heap.offer(1L);
        long num = 1L;
        for (int i = 0; i < k; i++) {
            num = heap.poll();
            for (int fac : factor) {
                long nextNum = num * fac;
                if (set.add(nextNum)) {
                    heap.offer(nextNum);
                }
            }
        }
        return (int) num;
    }
}

class Solution {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        // p3,p5,p7表示下标
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        for (int i = 1; i < k; i++) {
            int num3 = 3 * dp[p3];
            int num5 = 5 * dp[p5];
            int num7 = 7 * dp[p7];
            int nextNum = Math.min(num3, Math.min(num5, num7));
            dp[i] = nextNum;
            if (num3 == nextNum) {
                p3++;
            }
            if (num5 == nextNum) {
                p5++;
            }
            if (num7 == nextNum) {
                p7++;
            }
        }
        return dp[k - 1];
    }
}
