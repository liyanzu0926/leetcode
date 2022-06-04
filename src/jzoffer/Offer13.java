package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/6/4 12:15
 */
public class Offer13 {
}

class Solution13_1 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || (i / 10 + i % 10 + j / 10 + j % 10) > k) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i - 1, j, m, n, k, visited)
                + dfs(i + 1, j, m, n, k, visited)
                + dfs(i, j - 1, m, n, k, visited)
                + dfs(i, j + 1, m, n, k, visited)
                + 1;
    }
}

class Solution13_2 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || (i / 10 + i % 10 + j / 10 + j % 10) > k) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) + 1;
    }
}
