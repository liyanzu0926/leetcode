package homework;

public class RodCutting {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(memoizedCutRod(price, 4));

    }

    public static int memoizedCutRod(int[] price, int n) {
        int[] r = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return memoizedCutRodAux(price, n, r);
    }

    private static int memoizedCutRodAux(int[] price, int n, int[] r) {
        if (r[n] >= 0) return r[n];
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, price[i] + memoizedCutRodAux(price, n - i, r));
            }
        }
        r[n] = q;
        return q;
    }
}
