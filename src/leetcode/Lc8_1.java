package leetcode;

public class Lc8_1 {
    /**
     * 8. 字符串转换整数 (atoi)
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        int symbol = 1; //默认是正号
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' && !flag) {  //第一次遇到减号，将flag置为true，后面再遇到就break;
                flag = true;
                symbol = -1;
                continue;
            } else if (c == '+' && !flag) {  //第一次遇到加号，将flag置为true，后面再遇到就break;
                flag = true;
                continue;
            } else if (c == ' ' && !flag) {  //前导空格，如果flag为true说明不是前导空格了
                continue;
            } else if (c - '0' >= 0 && c - '0' <= 9) {
                flag = true;
                if (temp * symbol < Integer.MIN_VALUE / 10 || temp * symbol == Integer.MIN_VALUE / 10 && c - '0' >= 8) {
                    return Integer.MIN_VALUE;
                } else if (temp * symbol > Integer.MAX_VALUE / 10 || temp * symbol == Integer.MAX_VALUE / 10 && c - '0' >= 7) {
                    return Integer.MAX_VALUE;
                }
                temp = temp * 10 + c - '0';
            } else {
                break;
            }
        }
        return symbol * temp;
    }


    public static void main(String[] args) {
        String s = "   -42";
        System.out.println(myAtoi(s));
    }
}
