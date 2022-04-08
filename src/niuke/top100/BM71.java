package niuke.top100;

import java.util.*;


class BM71_1 {

    public int LIS(int[] arr) {
        // write code here
        int len = arr.length;
        if (arr == null || len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
}

class BM71_2 {

    public int LIS(int[] arr) {
        // write code here
        int len = arr.length;
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] d = new int[len + 1];
        int index = 1;
        d[index] = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] > d[index]) {
                d[++index] = arr[i];
            } else {
                int left = 1;
                int right = index;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (d[mid] < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[left] = arr[i];
            }
        }
        return index;
    }
}
