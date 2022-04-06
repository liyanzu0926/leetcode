package niuke.top100;

import java.util.*;


public class BM69 {

    public int solve(String nums) {
        // write code here
        int n = nums.length();
        if (n == 0 || nums.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int one = nums.charAt(i) - '0';
            int two = (nums.charAt(i - 1) - '0') * 10 + one;
            if (one != 0) {
                dp[i] = dp[i - 1];
            }
            if (two >= 10 && two <= 26) {
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n - 1];
    }
}
