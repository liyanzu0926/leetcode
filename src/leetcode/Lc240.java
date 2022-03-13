package leetcode;

public class Lc240 {
}

class Solution240_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (binarySearch(matrix[i], 0, n - 1, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] matrixRow, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrixRow[mid] == target) {
                return true;
            } else if (matrixRow[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

class Solution240_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x >= 0 && x < m && y >= 0 && y < n) {
            if (matrix[x][y] == target){
                return true;
            }else if (matrix[x][y] < target){
                x++;
            }else {
                y--;
            }
        }
        return false;
    }
}
