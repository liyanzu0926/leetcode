package leetcode;

public class Lc26 {
}

class Solution26_1 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1){
            return len;
        }
        int i = 0;
        int j = 1;
        while(j < len){
            if(nums[i] == nums[j]){
                j++;
            }else{
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
}
