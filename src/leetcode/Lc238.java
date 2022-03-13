package leetcode;

public class Lc238 {
}

class Solution238_1 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] answer = new int[len];
        L[0] = 1;
        R[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = nums[i - 1] * L[i - 1];
            R[len - i - 1] = nums[len - i] * R[len - i];
        }
        for (int i = 0; i < len; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
}

class Solution238_2 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int rightProduct = nums[len - 1];
        for (int i = len - 2; i >= 0 ; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return answer;
    }
}
