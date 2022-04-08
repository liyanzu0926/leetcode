package niuke.top100;

public class BM72 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(array[i], sum + array[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
