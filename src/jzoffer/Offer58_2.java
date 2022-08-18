package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/18 10:41
 */
public class Offer58_2 {
}

class Solution58_2_1 {
    public String reverseLeftWords(String s, int n) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, n - 1);
        reverse(arr, n, s.length() - 1);
        reverse(arr, 0, s.length() - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int low, int high) {
        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}

class Solution58_2_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
