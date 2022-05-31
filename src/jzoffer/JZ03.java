package jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author lww
 * @Date 2022/5/31 10:52
 */
public class JZ03 {
    public static void main(String[] args) {

    }
}

class Solution03_1 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
/**
 * @Description:
 * 每扫描到一个位置，就把这个位置上的val值对应位置做上标记，
 * 表示这个位置已有主人，只是这个主人不在这个位置。这里的标记为该值-n，即变为负数。
 * 当扫描到某个元素，如果该元素值对应位置小于0，说明该位置元素重复了（因为之前已经
 * 被标记了）
 * @author: lww
 * @date: 2022/5/31 11:39
 */
class Solution03_2 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int val = nums[i];
            if (val < 0) val += n; // 还原
            if (nums[val] < 0) return val; // 说明有两个元素重复了，nums[i] = nums[j] = val
            nums[val] -= n; // -n，相当于标记
        }
        return -1;
    }
}
