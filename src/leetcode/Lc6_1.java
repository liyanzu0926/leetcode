package leetcode;

import java.util.ArrayList;

public class Lc6_1 {
    //输入：s = "PAYPALISHIRING", numRows = 4
    //输出："PINALSIGYAHRPI"
    //解释：
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuffer());
        }
        boolean turnRound = false;  //往下走是true，往上走是false
        int row = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            list.get(row).append(c);
            if (row == 0 || row == numRows - 1) turnRound = !turnRound;  //第一行和最后一行需要转向
            row += turnRound ? 1 : -1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (StringBuffer sb : list) {
            stringBuffer.append(sb);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }
}
