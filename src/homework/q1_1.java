package homework;

public class q1_1 {
    /**
     * 求最长交替子序列
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {13, 93, 86, 50, 63, 4};
        int len = arr.length;
        // Z[i][0]记录索引i为止的最长交替子序列的长度，且为上升的
        // Z[i][1]记录索引i为止的最长交替子序列的长度，且为下降的
        int[][] Z = new int[len][2];
        // 如果子序列的长度为1，则我们定义它既是上升的也是下降的，所以初始化为1
        for (int i = 0; i < len; i++) {
            Z[i][0] = Z[i][1] = 1;
        }
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && Z[i][0] < Z[j][1] + 1){
                    Z[i][0] = Z[j][1] + 1;
                }else if (arr[j] > arr[i] && Z[i][1] < Z[j][0] + 1){
                    Z[i][1] = Z[j][0] + 1;
                }
            }
            if (res < Math.max(Z[i][0], Z[i][1])){
                res = Math.max(Z[i][0], Z[i][1]);
            }
        }
        System.out.println("最长交替子序列为：" + res);
    }
}
