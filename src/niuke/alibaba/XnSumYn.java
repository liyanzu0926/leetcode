package niuke.alibaba;

import java.util.*;

/**
 * f[0] = 2
 * f[1] = A
 * 递推公式 f[i] = A * f[i - 1] - B * f[i - 2]
 */
public class XnSumYn {
    public static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();


        for (int i = 0; i < T; i++) {
            int A = cin.nextInt();
            int B = cin.nextInt();
            int n = cin.nextInt();
            long d0 = 2;
            long d1 = A;
            for (int j = 2; j <= n; j++) {
                long d2 = (A * d1 % mod - B * d0 % mod + mod) % mod;
                d0 = d1;
                d1 = d2;
            }
            System.out.println(d1);
        }

    }


    /* 递归超时
    private static long f(int A, int B, int n){
        if(n == 0){
            return 2;
        }
        if(n == 1){
            return A;
        }
        return f(A, B, n - 1) * A % mod - f(A, B, n - 2) * B % mod;
    }
    */
}
