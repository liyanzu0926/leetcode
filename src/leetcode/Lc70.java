package leetcode;

public class Lc70 {
    public static void main(String[] args) {
        int n = 44;
        System.out.println(new Solution70_3().climbStairs(n));
    }
}

/**
 * 递归
 * f(1) = 1, f(2) = 2
 * f(i) = f(i - 1) + f(i - 2)
 * 方法正确，但超时了
 */
class Solution70_ {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

/**
 * 记忆递归
 * 用一个数组记录之前已经得到的路径数
 */
class Solution70_2 {
    public int climbStairs(int n) {
        //memo[n]位置上也要存数，所以数组长度要为n + 1
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        } else if (n == 1) {
            memo[n] = 1;
        } else if (n == 2) {
            memo[n] = 2;
        } else {
            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }
        return memo[n];
    }
}

/**
 * 动态规划
 * f(1) = 1, f(2) = 2
 * f(i) = f(i - 1) + f(i - 2)
 */
class Solution70_3 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}

/**
 * 优化动态规划
 * f(0) = 1, f(1) = 1
 * f(i) = f(i - 1) + f(i - 2)
 */
class Solution70_4 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
