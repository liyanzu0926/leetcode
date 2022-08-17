package jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/17 13:40
 */
public class Offer57_2 {
}

class Solution57_2_1 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1;
        int j = 1;
        int sum = 0;
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int x = i; x < j; x++) {
                    arr[x - i] = x;
                }
                res.add(arr);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
