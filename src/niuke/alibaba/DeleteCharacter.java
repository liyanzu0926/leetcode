package niuke.alibaba;

import java.util.*;

/**
 * 删除字符
 * https://www.nowcoder.com/questionTerminal/8951775b97d949628675398b6639d79c
 */
public class DeleteCharacter {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        while (T-- > 0) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            cin.nextLine();
            String str = cin.nextLine();
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (m > 0 && !stack.isEmpty() && stack.peek() > str.charAt(i)) {
                    stack.pop();
                    m--;
                }
                stack.push(str.charAt(i));
            }
            StringBuffer sb = new StringBuffer();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            System.out.println(sb.toString().substring(0, sb.length() - m));
        }

    }
}
