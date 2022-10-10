package daily;

import java.util.Arrays;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/10 12:21
 */
public class Lc801 {
}

class Solution801_1 {
    // 1. nums1[i-1]<nums1[i]且nums2[i-1]<nums2[i]
    // 2. nums1[i-1]<nums2[i]且nums2[i-1]<nums1[i]
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
            // 解释为什么第二个if要取min：情况1和情况2至少有一个满足，或者都满足。当都满足时，
            // 比如 nums1 = [1, 3], nums2 = [2, 4] ，此时可选择位置 i 和位置 i - 1 都交换或都不交换（情况1），
            // 也可选择只交换位置 i 或只交换位置 i - 1 （情况2），所以要取min(情况1，情况2）
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}

class Solution801_2 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int d1 = 0;
        int d2 = 1;
        for (int i = 1; i < n; i++) {
            int d1t = n;
            int d2t = n;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                d1t = d1;
                d2t = d2 + 1;
            }
            // 当不满足第1种情况时，d1t和d2t都是MAX_VALUE，所以d1t = d2, d2t = d1 + 1
            // 当满足第1种情况时，d1t和d2t都被更新
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                d1t = Math.min(d1t, d2);
                d2t = Math.min(d2t, d1 + 1);
            }
            d1 = d1t;
            d2 = d2t;
        }
        return Math.min(d1, d2);
    }
}
