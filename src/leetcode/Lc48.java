package leetcode;

import java.util.Arrays;

public class Lc48 {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new Solution48_1().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

class Solution48_1 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                swap(matrix, i, j, j, len - 1 - i);
                swap(matrix, i, j, len - 1 - i, len - 1 - j);
                swap(matrix, i, j, len - 1 - j, i);
            }
        }
    }

    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}
