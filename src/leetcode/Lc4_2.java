package leetcode;

/**
 * 力扣第4题
 * 寻找两个正序数组的中位数
 * 思想：划分数组
 * 参考b站https://www.bilibili.com/video/BV1H5411c7oC?from=search&seid=6268735660027855506
 */

public class Lc4_2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //保证第一个数组长度要小于等于第二个数组长度
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int median = (m + n + 1) / 2;
        double medianValue = 0.0;
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = median - i;
            if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else if (i != m && j != 0 && nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    medianValue = maxLeft;
                    break;
                } else {
                    int minRight = 0;
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums1[i], nums2[j]);
                    }
                    medianValue = (maxLeft + minRight) / 2.0;
                    break;
                }
            }
        }
        return medianValue;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 7};
        System.out.println(findMedianSortedArrays(arr1, arr2));

    }
}
