package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Lc79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Solution79_1().exist(board, word));
    }
}

class Solution79_1 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs2(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs1(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k >= word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = false;
        // 向上，向下，向左，向右
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dire : direction) {
            int newI = i + dire[0];
            int newJ = j + dire[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && !visited[newI][newJ]) {
                boolean flag = dfs1(board, word, visited, newI, newJ, k + 1);
                if (flag) {
                    res = flag;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return res;
    }

    private boolean dfs2(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        // 走到这里说明边界符合，且未被访问过，且和word匹配
        if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = dfs2(board, word, visited, i, j + 1, k + 1) ||
                dfs2(board, word, visited, i - 1, j, k + 1) ||
                dfs2(board, word, visited, i + 1, j, k + 1) ||
                dfs2(board, word, visited, i, j - 1, k + 1);
        visited[i][j] = false;
        return res;
    }
}
