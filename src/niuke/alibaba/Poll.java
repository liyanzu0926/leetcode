package niuke.alibaba;

import java.util.*;

/**
 * 蚂蚁森林之王
 * https://www.nowcoder.com/questionTerminal/276be492542443139857d02198817c3e
 */
public class Poll {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = cin.nextInt();
        }
        int[] poll = new int[n + 1];
        Arrays.fill(poll, 1);
        for (int i = n; i >= 1; i--) {
            if (a[i] != 0) {
                poll[a[i]] += poll[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(poll[i]);
        }
    }
}
