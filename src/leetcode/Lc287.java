package leetcode;


public class Lc287 {
}

class Solution287_1 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        // 注意 l 和 r 不是数组下标，而是1 到 n之间的数字,这里的n = len - 1
        int l = 1;
        int r = len - 1;
        int res = -1;
        while (l <= r){
            int mid = (l + r) >> 1;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid){
                    count++;
                }
            }
            if (count <= mid){
                l = mid + 1;
            }else {
                r = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}

class Solution287_2 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
