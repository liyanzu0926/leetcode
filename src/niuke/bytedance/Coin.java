package niuke.bytedance;

import java.util.*;

/**
 * 找零
 * https://www.nowcoder.com/questionTerminal/944e5ca0ea88471fbfa73061ebe95728
 */
public class Coin {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int n = 1024 - N;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] coin = {1, 4, 16, 64};
        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
