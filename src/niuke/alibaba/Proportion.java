package niuke.alibaba;

import java.util.*;

/**
 * 比例问题
 *
 * 链接：https://www.nowcoder.com/questionTerminal/669b796cf6074e1985eefe9b9b9cf103?answerType=1&f=discussion
 *
 * A / B = a / b 可以转化为A * b = B * a，
 * 一开始的思路是：当左边大了就让A--，当右边大了就让B--，直到相等为止，
 * 但这样会有一个用例超时，然后改进了一下，让A或B直接一步到位，到达最可能相等的状态。
 * 比如左边大了，让A = B * a / b ，因为你通过很多次减减的操作最终也是到达这个状态。
 * 此时等式要么相等（结束），要么左边小于右边（继续循环）。
 * 举个例子：
 * A * b = B * a
 * 5 * 2 > 3 * 3 左边大了，让A = 3 * 3 / 2 = 4
 * 4 * 2 < 3 * 3 右边大了，让B = 4 * 2 / 3 = 2
 * 4 * 2 > 2 * 3 左边大了，让A = 2 * 3 / 2 = 3
 * 3 * 2 = 2 * 3 相等
 */
public class Proportion {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        long A = cin.nextInt();
        long B = cin.nextInt();
        long a = cin.nextInt();
        long b = cin.nextInt();
        while(A >= 1 && B >=1){
            if(A * b > B * a){
                A = B * a / b;
            }else if(A * b < B * a){
                B = A * b / a;
            }else{
                System.out.println(A + " " + B);
                return;
            }
        }
        System.out.println(0 + " " + 0);
    }
}
