package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 3}};
        System.out.println(Arrays.deepToString(new Solution56_1().merge(intervals)));

    }
}

class Solution56_1 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //lambada表达式
        for (int i = 0; i < len; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < L) {
                list.add(new int[]{L, R});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], R);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
