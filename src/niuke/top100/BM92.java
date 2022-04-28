package niuke.top100;

import java.util.*;


public class BM92 {

    public int maxLength (int[] arr) {
        // write code here
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = -1;
        while(right < arr.length){
            // 扩大右指针，直到遇到重复元素
            while(right < arr.length && !set.contains(arr[right])){
                set.add(arr[right++]);
            }
            maxLen = Math.max(maxLen, right - left);
            if(right >= arr.length){
                break;
            }
            // 收缩左指针，直到重复元素被移出窗口
            while(left < right && arr[left] != arr[right]){
                set.remove(arr[left++]);
            }
            set.remove(arr[left++]);
        }
        return maxLen;
    }
}
