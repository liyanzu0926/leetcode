package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/11 11:37
 */
public class Offer46 {
}

class Solution46_1 {
    int count = 0;

    public int translateNum(int num) {
        dfs(num);
        return count;
    }

    private void dfs(int num) {
        if (num == 0) {
            count++;
            return;
        }
        dfs(num / 10);
        if (num % 100 <= 25 && num % 100 >= 10) {
            dfs(num / 100);
        }
    }
}

class Solution46_2 {
    public int translateNum(int num) {
        int d1 = 1;
        int d2 = 1;
        String str = String.valueOf(num);
        for (int i = 1; i < str.length(); i++) {
            // 如果str.substring(i - 1, i + 1)在“10”到“25”之间，则d3 = d2 + d1，
            // 否则d3 = d2 + 0;
            int d3 = d2 + ((str.substring(i - 1, i + 1).compareTo("10") >= 0 && str.substring(i - 1, i + 1).compareTo("25") <= 0) ? d1 : 0);
            d1 = d2;
            d2 = d3;
        }
        return d2;
    }
}
