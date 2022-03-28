package niuke.bytedance;

import java.util.*;

/**
 * 纠正拼写错误，如AAA->AA   AABB->AAB
 * https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92
 */
public class SpellingMistake {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        while (n-- > 0) {
            String str = cin.nextLine();
            char[] charArray = str.toCharArray();
            int len = str.length();
            int j = 0;
            for (int i = 0; i < len; i++) {
                charArray[j++] = charArray[i];
                if (j >= 3 && charArray[j - 1] == charArray[j - 2] && charArray[j - 2] == charArray[j - 3]) {
                    j--;
                } else if (j >= 4 && charArray[j - 1] == charArray[j - 2] && charArray[j - 3] == charArray[j - 4]) {
                    j--;
                }
            }
            System.out.println(new String(charArray, 0, j));
        }
    }
}

