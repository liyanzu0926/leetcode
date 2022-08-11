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
