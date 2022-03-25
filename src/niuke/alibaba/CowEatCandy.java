package niuke.alibaba;

import java.util.*;

/**
 * 牛牛们吃糖果
 * https://www.nowcoder.com/questionTerminal/e7a006abf5ec412a939f0d33725f06ed
 */
public class CowEatCandy {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] cow = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cow[i] = cin.nextInt();
        }
        int k = cin.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x = 0; x < k; x++) {
            int i = cin.nextInt();
            int j = cin.nextInt();
            map.put(i, j);
            map.put(j, i);
        }
        // 下面是合并两只有约定的牛
        // list中存放的数组有两个元素，一个是需要吃的糖果数量，一个是奶牛的数量
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == null) {
                    continue;
                }
                int j = map.get(i);
                int sum = cow[i] + cow[j];
                list.add(new int[]{sum, 2});
                map.put(j, null);
            } else {
                list.add(new int[]{cow[i], 1});
            }
        }

        // 下面是0/1背包代码，m是背包的容量
        int[] dp = new int[m + 1];
        for (int i = 0; i < list.size(); i++) {
            int w = list.get(i)[0];
            int c = list.get(i)[1];
            for (int j = m; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + c);
            }
        }
        System.out.println(dp[m]);
    }
}