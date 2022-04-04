package niuke.top100;

import java.util.*;

public class BM55 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> curr = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        recall(num);
        return res;
    }

    public void recall(int[] num) {
        if (curr.size() == num.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (curr.contains(num[i])) {
                continue;
            }
            curr.add(num[i]);
            recall(num);
            curr.remove(curr.size() - 1);
        }
    }
}
