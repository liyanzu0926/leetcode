package homework;

public class q1_2 {
    /**
     * 最长交替子序列
     */
    public static void main(String[] args) {
        int[] arr = {13, 93, 86, 50, 63, 4};
        int len = arr.length;
        int res = 1;
        int lastSign = 0;
        int sign;
        for (int i = 1; i < len; i++) {
            sign = (int) Math.signum(arr[i] - arr[i - 1]);
            //signum(x)，当x>0输出1，当x<0输出-1，当x=0输出0
            //sign != lastSign说明它是10<22>9或33>31<60这两种情况中的一种
            //即lastSign<arr[i - 1]>arr[i] 或lastSign>arr[i - 1]<arr[i]
            if (sign != lastSign && sign != 0){
                res += 1;
                lastSign = sign;
            }
        }
        System.out.println("最长交替子序列为：" + res);
    }
}
