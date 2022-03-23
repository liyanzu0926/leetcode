package niuke.alibaba;

/**
 * 子集
 * https://www.nowcoder.com/questionTerminal/a55198d2e65746009110226f2f6c8533
 */

import java.util.*;

public class Subset {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int n = cin.nextInt();
            int[][] goods = new int[n][2];
            for (int j = 0; j < n; j++) {
                goods[j][0] = cin.nextInt();
            }
            for (int j = 0; j < n; j++) {
                goods[j][1] = cin.nextInt();
            }
            // 按x从小到大排序，x相同再按y从大到小排序（目的是防止统计到重复的x）
            Arrays.sort(goods, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        return a[0] - b[0];
                    } else {
                        return b[1] - a[1];
                    }
                }
            });
            System.out.println(helper(goods));
        }
    }

    /**
     * 问题转化为“最长递增子序列”，leetcode的第300题
     * @param goods
     * @return
     */
    private static int helper(int[][] goods) {
        int len = goods.length;
        int[] val = new int[len + 1];
        int size = 1;
        val[size] = goods[0][1];
        for (int i = 1; i < len; i++) {
            if (goods[i][1] > val[size]) {
                val[++size] = goods[i][1];
            } else if (goods[i][1] < val[size]) {
                int left = 0;
                int right = size;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (val[mid] < goods[i][1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                val[left] = goods[i][1];
            }
        }
        return size;
    }
}
