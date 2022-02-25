package leetcode;

public class Lc7_1 {
    /**
     * 力扣第7题
     * 整数反转
     * Integer.MAX_VALUE = 2147483647，只需要提前判断temp是否大于214748364，或是否小于-214748364即可，
     * 因为如果temp大于214748364或小于-214748364，那么后面一位无论是什么都会溢出。
     * 当temp=214748364时，最后一位最多只能是1，不可能为2或大于2，假如为2，那么temp=2147483642，
     * 他是由2463847412翻转过来的，不存在这个整数，因为整数最大值才为2147483647。
     * 所以当temp=214748364时恒成立，如果最后一位存在，一定是1
     */
    public static int reverse(int x) {
        int temp = 0;
        while (x != 0) {
            if (temp > Integer.MAX_VALUE / 10 || temp < Integer.MIN_VALUE / 10) return 0;
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);//2147483647
        System.out.println(reverse(-2147483412));  //-2143847412
    }
}
