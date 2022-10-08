package leetcode;

import java.util.Arrays;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/8 10:21
 */
public class Lc2410 {
}

class Solution2410_1 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int m = players.length;
        int n = trainers.length;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && players[i] > trainers[j]) {
                j++;
            }
            if (j < n) {
                count++;
            }
        }
        return count;
    }
}
