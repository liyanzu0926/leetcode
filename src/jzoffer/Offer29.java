package jzoffer;

import java.util.Arrays;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/20 9:52
 */
public class Offer29 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(new Solution29_1().spiralOrder(matrix)));
    }
}

class Solution29_1 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        int[] res = new int[m * n];
        int index = 0;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[up][i];
            }
            for (int i = up + 1; i <= down; i++) {
                res[index++] = matrix[i][right];
            }
            if (left < right && up < down) {
                for (int i = right - 1; i >= left; i--) {
                    res[index++] = matrix[down][i];
                }
                for (int i = down - 1; i > up; i--) {
                    res[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
