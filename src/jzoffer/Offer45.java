package jzoffer;

import java.util.Arrays;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/10 15:41
 */
public class Offer45 {
}

class Solution45_1 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}

class Solution45_2 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quicksort(strs, 0, strs.length - 1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    private void quicksort(String[] strs, int low, int high) {
        if (low >= high) return;
        int i = low;
        int j = high;
        String pivot = strs[i];
        while (i < j) {
            while (i < j && (strs[j] + pivot).compareTo(pivot + strs[j]) >= 0) j--;
            if (i < j) {
                strs[i++] = strs[j];
            }
            while (i < j && (strs[i] + pivot).compareTo(pivot + strs[i]) < 0) i++;
            if (i < j) {
                strs[j--] = strs[i];
            }
        }
        strs[i] = pivot;
        quicksort(strs, low, i - 1);
        quicksort(strs, i + 1, high);
    }
}
