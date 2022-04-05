package niuke.top100;

class BM62_1 {
    public int Fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}

class BM62_2 {
    public int Fibonacci(int n) {
        int f1 = 1;
        int f2 = 1;
        for (int i = 3; i <= n; i++) {
            int f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f2;
    }
}