package leetcode;

import java.util.Arrays;

public class Lc16 {
}

class Solution16_1 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        int bestSum = Integer.MAX_VALUE - 1000;
        for(int i = 0; i < len; i++){
            if(i > 0 &&nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum - target) < Math.abs(bestSum - target)){
                    bestSum = sum;
                }
                if(target < sum){
                    k--;
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }else if(target > sum){
                    j++;
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                }else{
                    return sum;
                }
            }
        }
        return bestSum;
    }
}
