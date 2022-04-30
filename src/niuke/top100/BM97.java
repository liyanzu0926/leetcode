package niuke.top100;

import java.util.*;


public class BM97 {

    public int[] solve(int n, int m, int[] a) {
        // write code here
        int index = n - (m % n);
        reverse(a, 0, index - 1);
        reverse(a, index, n - 1);
        reverse(a, 0, n - 1);
        return a;
    }

    private void reverse(int[] a, int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
}
