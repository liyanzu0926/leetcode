package niuke.alibaba;

import java.util.*;

/**
 * 国际交流会
 * https://www.nowcoder.com/questionTerminal/afda747c4d0d414b839b7c37fc5e3baa
 */
public class MaxDifferent {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        Arrays.sort(a);
        int mid = (n & 1) == 0 ? n >> 1 : (n >> 1) + 1;
        int i = 0;
        int j = mid;
        int[] b = new int[n];
        int index = 0;
        long sum = 0;
        while (i < mid && j < n) {
            b[index++] = a[i++];
            b[index++] = a[j++];
        }
        if (i < mid) b[index++] = a[i];
        for (int x = 1; x < n; x++) {
            sum += Math.abs(b[x] - b[x - 1]);
        }
        sum += Math.abs(b[n - 1] - b[0]);
        System.out.println(sum);
        for (int x = 0; x < n; x++) {
            System.out.print(b[x] + " ");
        }
    }
}
