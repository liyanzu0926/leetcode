package niuke.top100;

import java.util.*;


public class BM59 {

    int res = 0;
    Set<Integer> column = new HashSet<>();
    Set<Integer> diagonal1 = new HashSet<>();
    Set<Integer> diagonal2 = new HashSet<>();

    public int Nqueen(int n) {
        // write code here
        recall(n, 0);
        return res;
    }

    private void recall(int n, int row) {
        if (row == n) {
            res++;
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
            column.add(i);
            diagonal1.add(d1);
            diagonal2.add(d2);
            recall(n, row + 1);
            column.remove(i);
            diagonal1.remove(d1);
            diagonal2.remove(d2);
        }
    }
}
