package jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/14 10:15
 */
public class Offer17 {
    public static void main(String[] args) {
    }
}

/**
 * @Description: 方法一
 * @author: lww
 * @date: 2022/7/14 10:47
 */
class Solution17_1 {
    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10.0, n) - 1;
        int[] res = new int[num];
        for (int i = 1; i <= num; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}

/**
 * @Description: 方法二
 * @author: lww
 * @date: 2022/7/14 10:47
 */
class Solution17_2 {

    private List<String> res;
    private StringBuffer cur;
    private char[] NUM;

    public Solution17_2() {
        res = new ArrayList();
        cur = new StringBuffer();
        NUM = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public int[] printNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            recall(0, i);
        }
        int len = res.size();
        int[] num = new int[len];
        // String转int
        for (int i = 0; i < len; i++) {
            num[i] = Integer.valueOf(res.get(i));
        }
        return num;
    }

    /**
     * @Description: 回溯
     * x表示当前第几位（从左边开始），len表示位数
     * @author: lww
     * @date: 2022/7/14 10:43
     */
    private void recall(int x, int len) {
        if (x == len) {
            res.add(cur.toString());
            return;
        }
        int start = x == 0 ? 1 : 0;
        for (int i = start; i < 10; i++) {
            cur.append(NUM[i]);
            recall(x + 1, len);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
