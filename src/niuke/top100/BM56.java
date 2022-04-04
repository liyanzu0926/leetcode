package niuke.top100;

import java.util.*;

public class BM56 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> curr = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        recall(num, visited);
        return res;
    }

    private void recall(int[] num, boolean[] visited) {
        if (curr.size() == num.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i] || i > 0 && num[i] == num[i - 1] && !visited[i - 1]) {
                continue;
            }
            curr.add(num[i]);
            visited[i] = true;
            recall(num, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}

