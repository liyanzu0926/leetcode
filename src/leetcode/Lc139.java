package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc139 {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < wordDict.length; i++) {
            list.add(wordDict[i]);
        }
        System.out.println(new Solution139_2().wordBreak(s, list));
    }
}

/**
 * 动态规划
 * dp[i]表示字符串s[0:i-1]是否可以被字典中的单词拼接而成。(i表示长度，不是下标)
 * 设0<= j <i，则判断字符串s是否合法（即dp[i]是否为true），只需判断s[0:j-1] 和s[j:i-1]是否都合法，
 * 而s[0:j-1]是否合法我们可以根据dp[j]得知，dp[j]此前已经计算出来，所以只需判断s[j:i-1]是否合法。
 * 当s[j:i-1]合法时，若dp[j]=true，则整个字符串s都合法，令dp[i]=true，否则不合法，令dp[i]=false
 */
class Solution139_1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true; //空字符串合法
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}

/**
 * 完全背包的思想
 * 字符串s长度表示背包容量
 * 单词长度表示每个物品的重量，价值表示是否能拼接成当前长度的字符串s
 * dp[i][j],表示前i个单词，是否可以组成长度为j的字符串
 * 当物品不放入背包 dp[i][j] = dp[i-1][j]
 * 当物品放入背包 dp[i][j] = dp[i][j-word.size]
 */
class Solution139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String word : wordDict) {
                int size = word.length();
                if (size <= i && s.substring(i - size, i).equals(word)){
                    dp[i] = dp[i] || dp[i - size];
                }
            }
        }
        return dp[len];
    }
}
