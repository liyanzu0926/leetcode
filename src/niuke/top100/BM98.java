package niuke.top100;

import java.util.ArrayList;

class BM98_1 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int leftEnd = 0;
        int rightEnd = n - 1;
        int upEnd = 0;
        int downEnd = m - 1;
        while (leftEnd <= rightEnd && upEnd <= downEnd) {
            for (int i = leftEnd; i <= rightEnd; i++) {
                res.add(matrix[upEnd][i]);
            }
            // 边界情况：只有一行，跳出循环
            if (upEnd + 1 > downEnd) {
                break;
            }
            for (int i = upEnd + 1; i <= downEnd; i++) {
                res.add(matrix[i][rightEnd]);
            }
            // 边界情况：只有一列，跳出循环
            if (rightEnd - 1 < leftEnd) {
                break;
            }
            for (int i = rightEnd - 1; i >= leftEnd; i--) {
                res.add(matrix[downEnd][i]);
            }
            for (int i = downEnd - 1; i > upEnd; i--) {
                res.add(matrix[i][leftEnd]);
            }
            leftEnd++;
            rightEnd--;
            upEnd++;
            downEnd--;
        }
        return res;
    }
}
