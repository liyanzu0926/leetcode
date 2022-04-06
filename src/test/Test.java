package test;

import java.util.*;


public class Test {
    public static void main(String[] args) {
        String s = "31717126241541717";
        System.out.println(solve(s));
    }

    public static int solve (String nums) {
        // write code here
        int n = nums.length();
        int[] dp = new int[n];
        dp[0] = 1;
        if(nums.charAt(0) - '0' > 0 && nums.charAt(0) - '0' <= 2 && nums.charAt(1) - '0' <= 6){
            dp[1] = 2;
        }else{
            dp[1] = 1;
        }
        for(int i = 2; i < n; i++){
            if(nums.charAt(i) - '0' == 0){
                dp[i] = dp[i - 2];
            }else if(nums.charAt(i - 1) - '0' > 0 && nums.charAt(i - 1) - '0' <= 2 && nums.charAt(i) - '0' <= 6){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}