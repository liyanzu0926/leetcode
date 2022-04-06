package niuke.top100;

import java.util.*;


public class BM70 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3};
        int aim = 20;
        System.out.println(minMoney(arr, aim));
    }

    public static int minMoney(int[] arr, int aim) {
        // write code here
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= aim; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        return dp[aim] == aim + 1 ? -1 : dp[aim];
    }
}
