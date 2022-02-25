package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 思想：回溯
 */
public class Lc17_1 {
    static Map<Integer, String> map = new HashMap<>();
    static StringBuffer stringBuffer = new StringBuffer();
    static ArrayList<String> list = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return list;
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        recall(digits, 0);
        return list;
    }

    private static void recall(String digits, int index) {
        if (stringBuffer.length() == digits.length()) {
            list.add(stringBuffer.toString());
            return;
        }
        String str = map.get(digits.charAt(index) - '0');
        for (char c : str.toCharArray()) {
            stringBuffer.append(c);
            recall(digits, index + 1);
            stringBuffer.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}