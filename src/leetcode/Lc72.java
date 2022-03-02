package leetcode;

public class Lc72 {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(new Solution72_1().minDistance(word1, word2));
    }
}

/**
 * 举个例子，word1 = "abcde", word2 = "fgh",找从word1，最少多少步，能变成word2？
 * 三种情况：
 * 1、知道"abcd"变成"fgh"多少步（假设X步），那么从"abcde"到"fgh"就是"abcde"->"abcd"->"fgh"。（一次删除，加X步，总共X+1步）
 * 2、知道"abcde"变成“fg”多少步（假设Y步），那么从"abcde"到"fgh"就是"abcde"->"fg"->"fgh"。（先Y步，再一次添加，加X步，总共Y+1步）
 * 3、知道"abcd"变成“fg”多少步（假设Z步），那么从"abcde"到"fgh"就是"abcde"->"fge"->"fgh"。（先不管最后一个字符，
 * 把前面的先变好，用了Z步，然后把最后一个字符给替换了。这里如果最后一个字符碰巧就一样，那就不用替换，省了一步）
 * <p>
 * 动态规划：
 * 状态转移方程：dp[i][j]=min(dp[i-1][j]+1,dp[i][j+1]+1,dp[i-1][j-1]+1)
 * 情况一dp[i-1][j]
 * 情况二dp[i][j-1]+1
 * 情况三dp[i-1][j-1]+int(word1[i]!=word2[j])
 */
class Solution72_1 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 如果有一个字符串长度为0，则编辑距离就为另一个字符串的长度
        if (len1 * len2 == 0) return len1 + len2;
        dp[0][0] = 0;
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
