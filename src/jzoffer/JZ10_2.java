package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/6/1 12:31
 */
public class JZ10_2 {
}

class Solution10_2_1 {
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }else if(n < 3){
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int ans = 0;
        for(int i = 3; i <= n; i++){
            ans = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = ans;
        }
        return ans;
    }
}

class Solution10_2_2 {
    public int numWays(int n) {
        int n0 = 1;
        int n1 = 1;
        int ans = 1;
        for(int i = 2; i <= n; i++){
            ans = (n0 + n1) % 1000000007;
            n0 = n1;
            n1 = ans;
        }
        return ans;
    }
}
