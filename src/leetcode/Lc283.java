package leetcode;

public class Lc283 {
}

class Solution283_1 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = len - 1, j = i; i >= 0 ; i--) {
            if (nums[i] == 0){
                int k = i;
                while (k + 1 <= j){
                    nums[k] = nums[k + 1];
                    k++;
                }
                nums[j] = 0;
                j--;
            }
        }
    }
}

class Solution283_2 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length){
            if (nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
            j++;
        }

    }
}
