package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 暴力法
 */

public class Lc22_1 {

    public static List<String> generateParenthesis(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> list = new ArrayList<>();
        generateAllParenthesis(0, n * 2, stringBuffer, list);
        return list;
    }

    private static void generateAllParenthesis(int pos, int max, StringBuffer stringBuffer, ArrayList<String> list) {
        if (pos == max) {
            if (valid(stringBuffer)) {
                list.add(stringBuffer.toString());
            }
        } else {
            stringBuffer.append("(");
            generateAllParenthesis(pos + 1, max, stringBuffer, list);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            stringBuffer.append(")");
            generateAllParenthesis(pos + 1, max, stringBuffer, list);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

    private static boolean valid(StringBuffer stringBuffer) {
        int balance = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.substring(i, i + 1).equals("(")) {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
