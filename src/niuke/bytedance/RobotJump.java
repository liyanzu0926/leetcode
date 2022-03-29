package niuke.bytedance;

import java.util.*;

/**
 * 机器人跳跃问题
 * https://www.nowcoder.com/questionTerminal/7037a3d57bbd4336856b8e16a9cafd71
 */
public class RobotJump {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int[] H = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            H[i] = cin.nextInt();
        }
        double res = 0;
        for (int i = N; i > 0; i--) {
            res = Math.ceil((H[i] + res) / 2);
        }
        System.out.println((long) res);
    }
}
