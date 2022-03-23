package leetcode;

public class Lc338 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
    }
}

class Solution338_1 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String str = Integer.toBinaryString(i);
            String replace = str.replace("1", "");
            ans[i] = str.length() - replace.length();
        }
        return ans;
    }
}

class Solution338_2 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = countOnes(i);
        }
        return ans;
    }

    private int countOnes(int x) {
        int count = 0;
        while (x > 0){
            x &= (x - 1);
            count++;
        }
        return count;
    }
}

/**
 * 动态规划
 * z = x - y
 * 其中y是x的最高有效位，即除了最高位为1其余全为0；
 * 则x比z多一个1，就是减去的这个最高位的1
 * 则当我们计算x的1个数时，只需用z的1个数加1即可，而z比x小，所以z的值已经计算出来了
 * bits[x] = bits[x - y] + 1
 * bits[x] = bits[z] + 1
 * 怎么计算y呢？y只有最高位为1，则y&(y-1)=0
 * 则我们可以遍历去寻找这么一个y
 */
class Solution338_3 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int y = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0){
                y = i;
            }
            bits[i] = bits[i - y] + 1;
        }
        return bits;
    }
}

/**
 * 动态规划
 * 用最低有效位来更新
 * x每次右移一位，如果x是偶数则bits[x] = bits[x/2]
 * 如果x是奇数则bits[x] = bits[x/2] + 1。
 * 怎么判断x是奇数还是偶数呢？
 * 可以用x除以2的余数来判断，而求x余数又可以用 x & 1来计算  (因为 a % x = a & (x - 1)）
 * 综上可得bits[x] = bits[x/2] + (x & 1)
 */
class Solution338_4 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}

/**
 * 动态规划
 * i & (i - 1)的功能是把i的最低位的1变成0，比如6的二进制位110，6 & 5 = 110 & 101 = 100
 * 设 y = i & (i - 1) ,则i中1的个数比y中1的个数多1，而y <= x的，因此我们计算 i 的时候，y已经计算出来了，
 * 则我们可以用y的值去更新i
 */
class Solution338_5 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}