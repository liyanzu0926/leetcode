package daily;

import java.util.Arrays;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/8 10:23
 */
public class Lc870 {
}

class Solution870_1 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] indexs1 = new Integer[n];
        Integer[] indexs2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexs1[i] = i;
            indexs2[i] = i;
        }
        int[] res = new int[n];
        Arrays.sort(indexs1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(indexs2, (i, j) -> nums2[i] - nums2[j]);
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[indexs1[i]] > nums2[indexs2[left]]) {
                res[indexs2[left++]] = nums1[indexs1[i]];
            } else {
                res[indexs2[right--]] = nums1[indexs1[i]];
            }
        }
        return res;
    }
}

class Solution870_2 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Integer[] index2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            index2[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(index2, (i, j) -> nums2[i] - nums2[j]);
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < m; i++) {
            if (nums1[i] > nums2[index2[left]]) {
                nums2[index2[left++]] = nums1[i];
            } else {
                nums2[index2[right--]] = nums1[i];
            }
        }
        return nums2;
    }
}
