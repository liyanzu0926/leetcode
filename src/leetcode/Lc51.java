package leetcode;

import java.util.*;

class Lc51_1 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        Set<Integer> column = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        recall(queue, n, 0, column, diagonal1, diagonal2);
        return res;
    }

    private void recall(int[] queue, int n, int row, Set<Integer> column, Set<Integer> diagonal1, Set<Integer> diagonal2) {
        if (row == n) {
            List<String> situation = generator(queue, n);
            res.add(situation);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (column.contains(i)) {
                continue;
            }
            int d1 = row - i;
            if (diagonal1.contains(d1)) {
                continue;
            }
            int d2 = row + i;
            if (diagonal2.contains(d2)) {
                continue;
            }
            queue[row] = i;
            column.add(i);
            diagonal1.add(d1);
            diagonal2.add(d2);
            recall(queue, n, row + 1, column, diagonal1, diagonal2);
            queue[row] = -1;
            column.remove(i);
            diagonal1.remove(d1);
            diagonal2.remove(d2);
        }
    }

    private List<String> generator(int[] queue, int n) {
        List<String> situation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queue[i]] = 'Q';
            situation.add(new String(row));
        }
        return situation;
    }
}
