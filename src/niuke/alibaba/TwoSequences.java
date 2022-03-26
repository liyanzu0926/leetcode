package niuke.alibaba;

import java.util.*;

/**
 * 两个序列
 * https://www.nowcoder.com/questionTerminal/b65b8b1376d94d4b8d4718ba2f4c0022
 */
public class TwoSequences {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(cin.nextInt(), i);
        }
        int res = 0;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (map.get(a[i]) > map.get(a[i - 1])) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        System.out.println(n - res);
    }
}
