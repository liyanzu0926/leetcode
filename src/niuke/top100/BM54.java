package niuke.top100;

import java.util.*;

public class BM54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) break; // 剪枝：最小的都大于0，三个数和肯定也大于0
            if (i > 0 && num[i] == num[i - 1]) continue; // 去重
            // 接下来是双指针
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                if (num[i] + num[left] + num[right] < 0) {
                    left++;
                } else if (num[i] + num[left] + num[right] > 0) {
                    right--;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    res.add(list);
                    left++;
                    right--;
                    // 去重
                    while (left < right && num[left] == num[left - 1]) left++;
                    while (left < right && num[right] == num[right + 1]) right--;
                }
            }
        }
        return res;
    }
}
