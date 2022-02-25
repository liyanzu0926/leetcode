package homework;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int n1 = 100, n2 = 1000, n3 = 10000, n4 = 100000;
//        int[] nums1 = new int[n1];
//        int[] nums2 = new int[n2];
//        int[] nums3 = new int[n3];
//        int[] nums4 = new int[n4];
//
//        LIS lis = new LIS();
//        lis.generateRandomArray(nums1);
//        lis.generateRandomArray(nums2);
//        lis.generateRandomArray(nums3);
//        lis.generateRandomArray(nums4);
//
//        long start, end;
//        int maxLen;

//        System.out.println("------------------------------------------------------");
//        System.out.println("n = 100时");
//        start = System.currentTimeMillis();
//        maxLen = lis.LIS_DP(nums1);
//        end = System.currentTimeMillis();
//        System.out.println("动态规划方法用时 ：" + (end - start) + "ms, 最长递增子序列为：" + maxLen);
//        start = System.currentTimeMillis();
//        maxLen = lis.LIS_BinarySearchAndGreedy(nums1);
//        end = System.currentTimeMillis();
//        System.out.println("二分+贪心方法用时：" + (end - start) + "ms, 最长递增子序列为：" + maxLen);
//        System.out.println("------------------------------------------------------");
//
//        System.out.println("n = 1000时");
//        start = System.currentTimeMillis();
//        maxLen = lis.LIS_DP(nums2);
//        end = System.currentTimeMillis();
//        System.out.println("动态规划方法用时 ：" + (end - start) + "ms, 最长递增子序列为：" + maxLen);
//        start = System.currentTimeMillis();
//        maxLen = lis.LIS_BinarySearchAndGreedy(nums2);
//        end = System.currentTimeMillis();
//        System.out.println("二分+贪心方法用时：" + (end - start) + "ms, 最长递增子序列为：" + maxLen);
//        System.out.println("------------------------------------------------------");
//
//        System.out.println("n = 10000时");
//        start = System.currentTimeMillis();
//        maxLen = lis.LIS_DP(nums3);
//        end = System.currentTimeMillis();
//        System.out.println("动态规划方法用时 ：" + (end - start) + "ms, 最长递增子序列为：" + maxLen);
//        start = System.currentTimeMillis();
//        maxLen = lis.LIS_BinarySearchAndGreedy(nums3);
//        end = System.currentTimeMillis();
//        System.out.println("二分+贪心方法用时：" + (end - start) + "ms, 最长递增子序列为：" + maxLen);
//        System.out.println("------------------------------------------------------");
//
//        System.out.println("n = 100000时");
//        start = System.currentTimeMillis();
//        maxLen = lis.LIS_DP(nums4);
//        end = System.currentTimeMillis();
//        System.out.println("动态规划方法用时 ：" + (end - start) + "ms, 最长递增子序列为：" + maxLen);
//        start = System.currentTimeMillis();
//        maxLen = lis.LIS_BinarySearchAndGreedy(nums4);
//        end = System.currentTimeMillis();
//        System.out.println("二分+贪心方法用时：" + (end - start) + "ms, 最长递增子序列为：" + maxLen);
//        System.out.println("------------------------------------------------------");


        LIS lis = new LIS();
        int[] nums = new int[n4];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            lis.generateRandomArray(nums);
            list.add(lis.LIS_BinarySearchAndGreedy(nums));
        }
        System.out.println(list.toString());
    }

    //产生一个1-len的随机数数组(元素无重复)，len为100、1000、10000、100000
    private void generateRandomArray(int[] nums) {
        int len = nums.length;
        int randomNum;
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            randomNum = (int) (Math.random() * len + 1);
            while (flag[randomNum - 1]){ //重复了就重新生成
                randomNum = (int) (Math.random() * len + 1);
            }
            nums[i] = randomNum;
            flag[randomNum - 1] = true;
        }
    }

    //动态规划
    private int LIS_DP(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLength = 1;
        int maxIndex = 0;
        int[] pre = new int[len];
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }
        //打印最长递增子序列
        printLIS(nums, pre, maxIndex, maxLength);
//        System.out.println("最长递增子序列为：" + maxLength);
        return maxLength;
    }

    //打印最长递增子序列
    private void printLIS(int[] nums, int[] pre, int maxIndex, int maxLength) {
        // 该数组用于存放最长递增子序列
        int[] arr = new int[maxLength];
        int i = maxIndex;
        int j = maxLength;
        while (j != 0) {
            arr[--j] = nums[i];
            i = pre[i];
        }
        System.out.println("最长递增子序列为：" + Arrays.toString(arr));
    }

    //二分+贪心
    protected int LIS_BinarySearchAndGreedy(int[] nums) {
        int len = nums.length;
        int[] d = new int[len + 1];
        int maxLen = 1;
        d[maxLen] = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] > d[maxLen]) {
                d[++maxLen] = nums[i];
            } else {
                int index = binarySearch(d, 1, maxLen, nums[i]);
                d[index + 1] = nums[i];
            }
        }
        return maxLen;
    }

    //二分查找dp数组中最后一个小于target的下标
    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return left - 1;
    }
}
