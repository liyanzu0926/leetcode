package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc85 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new Solution85_2().maximalRectangle(matrix));
    }
}

class Solution85_1 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int area;
        int width;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') continue;
                width = left[i][j];
                area = 1 * width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, width * (i - k + 1));
                }
                res = Math.max(res, area);
            }
        }
        return res;
    }
}

/**
 * 使用LC84中的单调栈的思想
 */
class Solution85_2 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int area = 0;
        for (int j = 0; j < col; j++) {
            int[] start = new int[row];
            int[] end = new int[row];
            Arrays.fill(end, row);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < row; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] > left[i][j]){
                    end[stack.peek()] = i;
                    stack.pop();
                }
                start[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < row; i++) {
                area = Math.max(area, (end[i] - start[i] - 1) * left[i][j]);
            }
        }
        return area;
    }
}
