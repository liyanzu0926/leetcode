package niuke.alibaba;

import java.util.*;

/**
 * 选择物品
 * https://www.nowcoder.com/questionTerminal/d03abbd6587d4951a9d2d872e310a3f3
 */
public class SelectItems {
    private static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        dfs(n, m, 1);
    }

    private static void dfs(int n, int m, int start) {
        if (list.size() == m) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add((Integer) i);
            dfs(n, m, i + 1);
            list.remove((Integer) i);
        }
    }
}
