package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/1 9:23
 */
public class Offer003 {
}

class Solution003_1 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private int count(int i) {
        if (i == 0) {
            return 0;
        }
        int count = 0;
        while (i != 0) {
            i &= (i - 1);
            count++;
        }
        return count;
    }
}

class Solution003_2 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int highBit = 1;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            dp[i] = dp[i - highBit] + 1;
        }
        return dp;
    }
}

class Solution003_3 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 如果i是偶数，则最后一位是0，右移一位不会影响1的个数
            // 如果i是奇数，则最后一位是1，右移一位会移去一个1，所以要加上1
            // 综上，只需加上i除以2的余数
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}

class Solution003_4 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
