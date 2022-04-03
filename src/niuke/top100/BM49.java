package niuke.top100;

import java.util.*;


public class BM49 {

    public int solve(String s) {
        // write code here
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        Deque<Integer> stack1 = new LinkedList<>(); // 存放操作数
        Deque<Character> stack2 = new LinkedList<>(); // 存放运算符和左括号
        s = "(" + s + ")"; // 这样可以使结束后栈中仅剩的一个数就是结果
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack2.push(ch);
            } else if (ch - '0' >= 0 && ch - '0' <= 9) {
                int num = 0;
                // 累加操作数
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                stack1.push(num);
            } else if (ch == '+' || ch == '-' || ch == '*') {
                if (!stack2.isEmpty() && priority.containsKey(stack2.peek()) && priority.get(ch) <= priority.get(stack2.peek())) {
                    int b = stack1.pop();
                    int a = stack1.pop();
                    char op = stack2.pop();
                    int c = operation(a, op, b);
                    stack1.push(c);
                }
                stack2.push(ch);
            } else {
                while (!stack2.isEmpty() && stack2.peek() != '(') {
                    int b = stack1.pop();
                    int a = stack1.pop();
                    char op = stack2.pop();
                    int c = operation(a, op, b);
                    stack1.push(c);
                }
                stack2.pop();
            }
            i++;
        }
        return stack1.pop();
    }

    private int operation(int a, char op, int b) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        return a / b;
    }
}
