package leetcode;

public class Lc200 {
    public static void main(String[] args) {

    }
}

class Solution200_1 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    islandNum++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return islandNum;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1')dfs(grid, i - 1, j, m, n);
        if (i + 1 < m && grid[i + 1][j] == '1')dfs(grid, i + 1, j, m, n);
        if (j - 1 >= 0 && grid[i][j - 1] == '1')dfs(grid, i, j - 1, m, n);
        if (j + 1 < n && grid[i][j + 1] == '1')dfs(grid, i, j + 1, m, n);
    }
}
