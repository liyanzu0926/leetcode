package leetcode;

/**
 * 14. 最长公共前缀
 * 思想：纵向扫描，当某个字符串扫描到末尾，或某个字符串的当前字符与其它字符串的字符不相等则跳出循环，返回结果
 */
public class Lc14_1 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs[0].equals("")) return "";
        String str = "";
        int i = 0; //i表示字符串中第几个字符
        while (true) {
            for (int j = 0; j < strs.length; j++) { //j表示第几个字符串
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return str;
                }
            }
            str = strs[0].substring(0, i + 1);  //走到这里说明所有字符串的前i个字符都匹配
            i++;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
