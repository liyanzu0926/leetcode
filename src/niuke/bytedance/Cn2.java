package niuke.bytedance;

import java.util.*;

/**
 * 排列组合
 * https://www.nowcoder.com/questionTerminal/c0803540c94848baac03096745b55b9b
 */
public class Cn2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int D = cin.nextInt();
        int[] coordinate = new int[N];
        for (int i = 0; i < N; i++) {
            coordinate[i] = cin.nextInt();
        }
        long res = 0;
        int j = 2;
        for (int i = 0; i < N - 2; i++) {
            while (j < N && coordinate[j] - coordinate[i] <= D) {
                j++;
            }
            long num = j - 1 - i;
            if (num < 2) {
                continue;
            }
            res += (num - 1) * num / 2;
        }
        System.out.println(res % 99997867);
    }
}