package leetcode;

/**
 * 11. 盛最多水的容器
 * 思想：双指针
 * 每次height小的指针移动
 */

public class Lc11_1 {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = -1;
        while (i < j) {
            if ((j - i) * Math.min(height[i], height[j]) > max) {
                max = (j - i) * Math.min(height[i], height[j]);
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
