package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/18 11:30
 */
public class Offer20 {
}

class Solution20_1 {
    public boolean isNumber(String s) {
        s = s.trim(); // 去掉前后空格
        if (isDecimal(s) || isInteger(s)) { // 判断是小数或是整数
            return true;
        }
        // 来到这里说明s中‘可能’包含字母e
        s = s.toLowerCase(); // 将s转为小写
        int index = s.indexOf("e"); // 返回'e'在s中的位置
        if (index == -1) { // 如果为-1说明不包含e，则说明s既不是小数也不是整数，也没包含e
            return false;
        } else {
            // (e之前是整数或小数) && (e之后必须为整数)
            return (isDecimal(s.substring(0, index)) || isInteger(s.substring(0, index)))
                    && isInteger(s.substring(index + 1));
        }
    }

    // 判断是否为小数
    private boolean isDecimal(String str) {
        if (str.length() == 0) {
            return false;
        }
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            str = str.substring(1);
        }
        int index = str.indexOf(".");
        if (index == -1) { //不包含'.'，说明不是小数
            return false;
        }
        // (数字.) || (数字.数字) || (.数字)
        return (isLeastOneDigit(str.substring(0, index)) && index == str.length() - 1) ||
                (isLeastOneDigit(str.substring(0, index)) && isLeastOneDigit(str.substring(index + 1))) ||
                (index == 0 && (isLeastOneDigit(str.substring(index + 1))));
    }

    // 判断字符串Str中是否全为数字，且至少包含一个数字
    private boolean isLeastOneDigit(String str) {
        if (str.length() == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            count++;
        }
        return count >= 1;
    }

    // 判断是否为整数
    private boolean isInteger(String str) {
        if (str.length() == 0) {
            return false;
        }
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            str = str.substring(1);
        }
        return isLeastOneDigit(str);
    }
}
