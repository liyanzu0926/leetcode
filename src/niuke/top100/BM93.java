package niuke.top100;

import java.util.*;


public class BM93 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxVal = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxVal = Math.max(maxVal, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxVal;
    }
}
