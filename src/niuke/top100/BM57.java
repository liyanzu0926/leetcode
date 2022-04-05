package niuke.top100;

import java.util.*;

/**
 * dfs
 */
class BM57_1 {

    public int solve(char[][] grid) {
        // write code here4
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    dfs(grid, i, j);
                }
            }
        }
        return island;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

/**
 * bfs
 */
class BM57_2 {

    public int solve(char[][] grid) {
        // write code here
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    bfs(grid, i, j);
                }
            }
        }
        return island;
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<Integer> queue = new LinkedList<>();
        int code = i * n + j;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int x = code / n;
            int y = code % n;
            grid[x][y] = '0';
            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                queue.offer((x - 1) * n + y);
            }
            if (x + 1 < m && grid[x + 1][y] == '1') {
                queue.offer((x + 1) * n + y);
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                queue.offer(x * n + y - 1);
            }
            if (y + 1 < n && grid[x][y + 1] == '1') {
                queue.offer(x * n + y + 1);
            }
        }
    }
}
