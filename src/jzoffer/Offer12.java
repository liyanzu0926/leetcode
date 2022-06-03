package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/6/3 14:11
 */
public class Offer12 {
    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}};
        String word = "aaa";
        System.out.println(new Solution12_1().exist(board, word));
    }
}

class Solution12_1 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = callback(board, i, j, visited, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean callback(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dire : direction) {
            int newI = i + dire[0];
            int newJ = j + dire[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && !visited[newI][newJ]) {
                if (callback(board, newI, newJ, visited, word, index + 1)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}