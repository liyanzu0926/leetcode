package daily;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/8 13:40
 */
public class Lc1694 {
}

class Solution1694_1 {
    public String reformatNumber(String number) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        int n = sb.length();
        StringBuffer res = new StringBuffer();
        int index = 0;
        while (n > 0) {
            if (n < 4) {
                res.append(sb.substring(index));
                break;
            } else if (n == 4) {
                res.append(sb.substring(index, index + 2) + "-" + sb.substring(index + 2, index + 4));
                break;
            } else {
                res.append(sb.substring(index, index + 3) + "-");
                index += 3;
                n -= 3;
            }
        }
        return res.toString();
    }
}
