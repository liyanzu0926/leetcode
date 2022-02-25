package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 优化暴力法，增加剪纸操作
 */

public class Lc22_2 {

    public static List<String> generateParenthesis(int n) { //这里的n表示n对括号
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> list = new ArrayList<>();
        generateAllParenthesis(0, 0, n, stringBuffer, list);
        return list;
    }

    //leftBracketNum为左括号的数量，rightBracketNum为右括号的数量
    private static void generateAllParenthesis(int leftBracketNum, int rightBracketNum, int max, StringBuffer stringBuffer, ArrayList<String> list) {
        if (stringBuffer.length() == max * 2) {
            list.add(stringBuffer.toString());
        } else {
            if (leftBracketNum < max) {
                stringBuffer.append("(");
                generateAllParenthesis(leftBracketNum + 1, rightBracketNum, max, stringBuffer, list);
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            if (rightBracketNum < leftBracketNum) {
                stringBuffer.append(")");
                generateAllParenthesis(leftBracketNum, rightBracketNum + 1, max, stringBuffer, list);
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
