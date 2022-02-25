package leetcode;

public class Lc9_2 {
    /**
     * 9. 回文数
     * 如果将x整个翻转过来再比较的话，可能会溢出（大于int.max），所以只需要处理到整数x的一半即可
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNum || x == revertedNum / 10;
    }

    public static void main(String[] args) {

    }
}
