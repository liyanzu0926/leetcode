package leetcode;

public class Lc344 {
}

class Solution344 {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i < len / 2; i++){
            char ch = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = ch;
        }
    }
}
