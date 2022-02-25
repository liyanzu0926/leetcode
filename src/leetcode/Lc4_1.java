package leetcode;

/**
 * 力扣第4题
 * 寻找两个正序数组的中位数
 * 思想：归并
 */

public class Lc4_1 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median = (nums1.length + nums2.length) / 2 + 1;
        int i = 0;
        int j = 0;
        int count = 0;
        double temp = 0;
        if ((nums1.length + nums2.length) % 2 == 1) {
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    temp = nums1[i];
                    i++;
                } else {
                    temp = nums2[j];
                    j++;
                }
                count++;
                if (count == median) break;
            }
            if (count == median) return temp;
            while (i < nums1.length) {
                count++;
                if (count == median) {
                    temp = nums1[i];
                    break;
                }
                i++;
            }
            while (j < nums2.length) {
                count++;
                if (count == median) {
                    temp = nums2[j];
                    break;
                }
                j++;
            }
        } else {
            double temp1 = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    temp = nums1[i];
                    i++;
                } else {
                    temp = nums2[j];
                    j++;
                }
                count++;
                if (count == median - 1) temp1 = temp;
                if (count == median) {
                    temp = (temp1 + temp) / 2;
                    break;
                }
            }
            if (count == median) return temp;
            while (i < nums1.length) {
                count++;
                temp = nums1[i];
                if (count == median - 1) temp1 = temp;
                if (count == median) {
                    temp = (temp1 + nums1[i]) / 2;
                    break;
                }
                i++;
            }
            while (j < nums2.length) {
                count++;
                temp = nums2[j];
                if (count == median - 1) temp1 = temp;
                if (count == median) {
                    temp = (temp1 + nums2[j]) / 2;
                    break;
                }
                j++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int nums1[] = {0, 0, 0, 0, 0};
        int nums2[] = {-1, 0, 0, 0, 0, 0, 1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

//[0,0,0,0,0]
//[-1,0,0,0,0,0,1]

//0
