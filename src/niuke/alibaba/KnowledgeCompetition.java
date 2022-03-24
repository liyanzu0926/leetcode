package niuke.alibaba;

import java.util.*;

/**
 * 知识竞赛
 * https://www.nowcoder.com/questionTerminal/2a9089ea7e5b474fa8f688eae76bc050
 */

/**
 * 如果 a - b > c - d
 * 则 a + d > b + c
 *
 * 先按a-b的绝对值从小到大排序
 * b + max(b) <= a + 最大b员工的a项
 */

public class KnowledgeCompetition {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] info = new int[n][2];
        for (int i = 0; i < n; i++) {
            info[i][0] = cin.nextInt();
            info[i][1] = cin.nextInt();
        }
        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Math.abs(a[0] - a[1]) - Math.abs(b[0] - b[1]);
            }
        });
        int maxMin = 0;
        int currMaxMin = 0;
        int maxA = info[0][0];
        int maxB = info[0][1];
        for (int i = 1; i < n; i++) {
            if (info[i][0] < info[i][1]) {
                currMaxMin = info[i][0] + maxA; // i的A属性较弱，所以和A属性最大的员工合作弥补A的下限
            } else {
                currMaxMin = info[i][1] + maxB; // i的B属性较弱，所以和B属性最大的员工合作弥补B的下限
            }
            // 不用担心上面弱属性加上若属性对应的属性最大值后（比如A + maxA）比另一个属性的要大（比如 B + maxA对应的B属性）
            // 因为 b1 - a1 <= a2 - b2, 则a2 + a1 >= b1 + b2
            // 所以若属性即使加上最大值也不会超过另一个属性
            maxMin = Math.max(maxMin, currMaxMin);
            maxA = Math.max(maxA, info[i][0]);
            maxB = Math.max(maxB, info[i][1]);
        }
        System.out.println(maxMin / 2);
    }
}
