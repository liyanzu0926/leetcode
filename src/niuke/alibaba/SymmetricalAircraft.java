package niuke.alibaba;

import java.util.*;

/**
 * 对称飞行器
 * https://www.nowcoder.com/questionTerminal/ef231526f822489d879949226b4bed65?answerType=1
 */
public class SymmetricalAircraft {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        String line = cin.nextLine();
        char[][] maze = new char[n][m];
        int sX = 0, sY = 0;
        for (int i = 0; i < n; i++) {
            line = cin.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                maze[i][j] = ch;
                if (ch == 'S') {
                    sX = i;
                    sY = j;
                }
            }
        }
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visied = new boolean[n][m];
        // 这四个值分别是该点的横坐标、纵坐标、飞行次数、路径长度
        queue.offer(new int[]{sX, sY, 0, 0});
        visied[sX][sY] = true;
        int minPath = Integer.MAX_VALUE - 1;
        int[][] detection = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {n - 1, m - 1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int flyNum = node[2];
            int path = node[3];
            for (int i = 0; i < 5; i++) {
                int newX, newY, newFlyNum, newPath;
                if (i == 4) {
                    // i = 4 为乘飞行器，飞行次数不能超过5次
                    if (flyNum > 5) {
                        break;
                    }
                    newX = detection[i][0] - x;
                    newY = detection[i][1] - y;
                    newFlyNum = flyNum + 1;
                } else {
                    newX = x + detection[i][0];
                    newY = y + detection[i][1];
                    newFlyNum = flyNum;
                }
                // 判断路径是否合法
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || maze[newX][newY] == '#' || visied[newX][newY]) {
                    continue;
                }
                // 来到这里说明该路径是合法的
                newPath = path + 1;
                if (maze[newX][newY] == 'E') {
                    minPath = Math.min(minPath, newPath);
                    continue;
                }
                queue.offer(new int[]{newX, newY, newFlyNum, newPath});
                visied[newX][newY] = true;
            }
        }
        if (minPath == Integer.MAX_VALUE - 1) {
            System.out.println(-1);
        } else {
            System.out.println(minPath);
        }
    }
}
