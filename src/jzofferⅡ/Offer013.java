package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/8 11:20
 */
public class Offer013 {
}

class NumMatrix013_1 {
    int[][] matrix = null;

    public NumMatrix013_1(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += this.matrix[i][j];
            }
        }
        return sum;
    }
}

class NumMatrix013_2 {
    int[][] sums;

    public NumMatrix013_2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i][j + 1] = sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }
}


