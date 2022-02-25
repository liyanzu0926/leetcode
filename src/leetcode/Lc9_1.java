package leetcode;

import java.util.ArrayList;

public class Lc9_1 {
    /**
     * 9. 回文数
     * 将x整个翻转过来再比较
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false; //小于0或末尾为0，一定不是回文数
        ArrayList<Integer> integers = new ArrayList<>();
        int temp = x;
        while (temp != 0) {
            integers.add(temp % 10);
            temp /= 10;
        }
        while (x != 0) {
            if (x % 10 != integers.remove(integers.size() - 1)) {
                return false;
            }
            x /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
