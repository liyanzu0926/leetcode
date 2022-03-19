package leetcode;

public class Lc461 {
}

class Solution461_1 {
    public int hammingDistance(int x, int y) {
        int k = x ^ y;
        int count = 0;
        while(k != 0){
            k = k & (k - 1);
            count++;
        }
        return count;
    }
}
