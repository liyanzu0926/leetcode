package jzoffer;

import java.util.Arrays;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/26 10:52
 */
public class Offer66 {
}

class Solution66_1 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }
        int[] left = new int[len];
        int[] right = new int[len];
        int[] ans = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}

class Solution66_2 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * a[i - 1];
        }
        int right = 1;
        for (int i = len - 2; i >= 0; i--) {
            right *= a[i + 1];
            ans[i] *= right;
        }
        return ans;
    }
}

class Solution66_3 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }
        int[] ans = new int[len];
        Arrays.fill(ans, 1);
        int left = 1;
        int right = 1;
        for (int i = 0; i < len; i++) {
            ans[i] *= left;
            ans[len - i - 1] *= right;
            left *= a[i];
            right *= a[len - i - 1];
        }
        return ans;
    }
}
