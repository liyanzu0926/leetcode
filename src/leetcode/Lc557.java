package leetcode;

public class Lc557 {
}

class Solution557_1 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reverse(arr[i]);
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String reverse(String str) {
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        for (int i = 0; i < len / 2; i++) {
            char ch = charArr[i];
            charArr[i] = charArr[len - 1 - i];
            charArr[len - 1 - i] = ch;
        }
        return new String(charArr);
    }
}

class Solution557_2 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < split.length; i++){
            split[i] = new StringBuffer(split[i]).reverse().toString();
        }
        return String.join(" ", split);
    }
}
