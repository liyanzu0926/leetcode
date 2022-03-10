package leetcode;

public class Lc169 {
    public static void main(String[] args) {

    }
}

class Solution169_1 {
    public int majorityElement(int[] nums) {
        int count  = 1;
        int primary = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == primary){
                count++;
            }else {
                count--;
            }
            if (count <= 0){
                primary = nums[i];
                count = 1;
            }
        }
        return primary;
    }
}
