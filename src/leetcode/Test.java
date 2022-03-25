package leetcode;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int k = 0; k < T; k++) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[][] grid = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    grid[i][j] = cin.nextInt();
                }
            }

            int[][] dp = new int[n + 1][m + 1];
            dp[1][1] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i == n && j == m) {
                        break;
                    }
                    update(grid, i, j, dp);
                }
            }
            System.out.println(dp[n][m]);
        }
    }

    private static void update(int[][] grid, int i, int j, int[][] dp) {
        int n = grid.length - 1;
        int m = grid[0].length - 1;
        int energy = grid[i][j];
        int rowEnd = Math.min(i + energy, n);
        int colEnd = Math.min(j + energy, m);
        for (int x = i + 1; x <= rowEnd; x++) {
            dp[x][j] = (dp[x][j] + dp[i][j]) % 10000;
        }
        for (int y = j + 1; y <= colEnd; y++) {
            dp[i][y] = (dp[i][y] + dp[i][j]) % 10000;
        }
        rowEnd--;
        colEnd--;
        for (int x = i + 1; x <= rowEnd; x++) {
            for (int y = j + 1; y <= colEnd; y++) {
                dp[x][y] = (dp[x][y] + dp[i][j]) % 10000;
            }
            colEnd--;
        }
    }
}