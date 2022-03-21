package leetcode;

public class Lc59 {
}

class Solution59_1 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rightEnd = n - 1;
        int downEnd = n - 1;
        int leftEnd = 0;
        int upEnd = 0;
        int index = 1;
        while (index <= n * n) {
            for (int i = leftEnd; i <= rightEnd; i++) {
                res[upEnd][i] = index++;
            }
            upEnd++;
            for (int i = upEnd; i <= downEnd; i++) {
                res[i][rightEnd] = index++;
            }
            rightEnd--;
            for (int i = rightEnd; i >= leftEnd; i--) {
                res[downEnd][i] = index++;
            }
            downEnd--;
            for (int i = downEnd; i >= upEnd; i--) {
                res[i][leftEnd] = index++;
            }
            leftEnd++;
        }
        return res;
    }
}
