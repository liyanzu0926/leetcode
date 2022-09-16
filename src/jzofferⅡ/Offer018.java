package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/16 9:38
 */
public class Offer018 {
    public static void main(String[] args) {
        System.out.println(new Solution018_1().isPalindrome("A man, a plan, a canal: Panama"));
    }
}

class Solution018_1 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 移动左指针，直到找到一个合法字符
            while (left < right && !check(s.charAt(left))) {
                left++;
            }
            // 移动右指针，直到找到一个合法字符
            while (left < right && !check(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean check(char ch) {
        if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z') {
            return true;
        }
        return false;
    }
}
