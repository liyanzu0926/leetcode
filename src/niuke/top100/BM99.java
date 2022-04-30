package niuke.top100;

import java.util.*;

class BM99_1 {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        if (n == 0) {
            return mat;
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                swap(mat, i, j, j, n - 1 - i);
                swap(mat, i, j, n - 1 - i, n - 1 - j);
                swap(mat, i, j, n - 1 - j, i);
            }
        }
        return mat;
    }

    private void swap(int[][] mat, int row1, int col1, int row2, int col2) {
        int temp = mat[row1][col1];
        mat[row1][col1] = mat[row2][col2];
        mat[row2][col2] = temp;
    }
}


class BM99_2 {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = mat[i][j];
            }
        }
        return res;
    }
}
