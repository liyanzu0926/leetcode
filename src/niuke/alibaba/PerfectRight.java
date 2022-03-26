package niuke.alibaba;

import java.util.*;

/**
 * 完美对
 * https://www.nowcoder.com/questionTerminal/f5a3b5ab02ed4202a8b54dfb76ad035e
 */
public class PerfectRight {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] a = new int[k];
            for (int j = 0; j < k; j++) {
                a[j] = cin.nextInt();
            }
            int[] b = new int[k - 1];
            for (int j = 1; j < k; j++) {
                b[j - 1] = a[j] - a[j - 1];
            }
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            for (int j = 0; j < k - 1; j++) {
                sb1.append(b[j]);
                sb2.append(-b[j]);
            }
            res += map.getOrDefault(sb1.toString(), 0);
            map.put(sb2.toString(), map.getOrDefault(sb2.toString(), 0) + 1);
        }
        System.out.println(res);
    }
}
