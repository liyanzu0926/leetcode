package niuke.top100;

import java.util.*;


public class BM95 {

    public int candy(int[] arr) {
        // write code here
        int len = arr.length;
        int[] candy = new int[len];
        Arrays.fill(candy, 1);
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        int sum = candy[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
            sum += candy[i];
        }
        return sum;
    }
}
