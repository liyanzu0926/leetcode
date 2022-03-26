package niuke.alibaba;

import java.util.*;

/**
 * 小强修水渠
 * https://www.nowcoder.com/questionTerminal/ca184e56353b4a9db1872af554694013
 * 对x坐标排序之后，使水渠位置始终在一对最外层x之间
 * 这一对x到水渠的距离为 xRight - xLeft
 */
public class RepairCanal {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] coordinate = new int[n][2];
        long res = 0;
        for (int i = 0; i < n; i++) {
            coordinate[i][0] = cin.nextInt();
            coordinate[i][1] = cin.nextInt();
        }
        Arrays.sort(coordinate, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n / 2; i++) {
            res += coordinate[n - 1 - i][0] - coordinate[i][0];
        }
        System.out.println(res);
    }
}
