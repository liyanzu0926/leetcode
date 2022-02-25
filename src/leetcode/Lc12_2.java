package leetcode;

/***
 * lc12
 * 将个、十、百、千 每位的编码罗列出来，然后对num取模，对应下标的编码即为该为的编码
 * num<=3999
 */

public class Lc12_2 {
    public static String intToRoman(int num) {
        String[] thousand = {"", "M", "MM", "MMM"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.insert(0, one[num % 10]);
        num /= 10;
        stringBuffer.insert(0, ten[num % 10]);
        num /= 10;
        stringBuffer.insert(0, hundred[num % 10]);
        num /= 10;
        stringBuffer.insert(0, thousand[num % 10]);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
