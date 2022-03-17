package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Lc394 {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new Solution394_1().decodeString(s));
    }
}

class Solution394_1 {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!s.substring(i, i + 1).equals("]")) {
                stack.push(s.substring(i, i + 1));
            } else {
                StringBuffer sb = new StringBuffer();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.poll());
                }
                stack.pop();
                StringBuffer nums = new StringBuffer();
                while (!stack.isEmpty() && stack.peek().length() == 1 && (stack.peek().toCharArray()[0] >= '0' && stack.peek().toCharArray()[0] <= '9')) {
                    nums.insert(0, stack.pop());
                }
                if (nums.length() != 0) {
                    int num = Integer.parseInt(nums.toString());
                    String str = sb.toString();
                    for (int j = 0; j < num - 1; j++) {
                        sb.append(str);
                    }
                }
                stack.push(sb.toString());
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {

            stringBuffer.insert(0, stack.pop());
        }
        return stringBuffer.toString();
    }
}
