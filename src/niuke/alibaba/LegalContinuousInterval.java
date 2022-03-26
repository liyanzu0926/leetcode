package niuke.alibaba;

import java.util.*;

/**
 * 合法连续子段
 * https://www.nowcoder.com/questionTerminal/778ae1581eb54959bce91afe0b51c3ff
 */
public class LegalContinuousInterval {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        long count = 0;
        while (j < n && i <= j) {
            int num = map.getOrDefault(a[j], 0) + 1;
            map.put(a[j], num);
            if (num == m) {
                // 如果到j这里满足条件，那么所有j之后也都满足，直接计算有多少个区间
                count += n - j;
                // i向前移，直到区间不满足条件
                while (i < j && map.get(a[i]) != num) {
                    map.put(a[i], map.get(a[i]) - 1);
                    i++;
                    count += n - j;
                }
                if (map.get(a[i]) == num) {
                    map.put(a[i], map.get(a[i]) - 1);
                    i++;
                }
            }
            j++;
        }
        System.out.println(count);
    }
}
