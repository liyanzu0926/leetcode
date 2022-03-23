package leetcode;

import java.util.Scanner;

public class Lc440 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int i = cin.nextInt();
        System.out.println(new Solution440_1().findKthNumber(1,1));
    }
}

class Solution440_1 {
    public int findKthNumber(int n, int k) {
        int res = 0;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            int power = 0;
            int level = i;
            while (k > 0 && level < n) {
                level = (int) (i * Math.pow(10, power++));
                k--;
                if (k == 0) {
                    res = level;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            level /= 10;
            k++;
            while (level > 1) {
                for (int j = 1; j < 10 && level < n; j++) {
                    level += j;
                    k--;
                    if (k == 0) {
                        res = level;
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
                k++;
                level /= 10;
            }
        }
        return res;
    }
}
