package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Lc42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution42_1 solution42 = new Solution42_1();
        System.out.println(solution42.trap(height));
    }
}

/**
 * 动态规划
 */
class Solution42_1 {
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[len - i - 1] = Math.max(rightMax[len - i], height[len - i - 1]);
        }
        for (int i = 0; i < len; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

}

/**
 * 单调栈
 */
class Solution42_2 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        int currWidth, currHeight;
        int res = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                //中间柱子下标
                int mid = stack.pop();
                //如果栈为空说明左边没有柱子了，则结束
                if (stack.isEmpty()) break;
                //两边柱子下标差即为宽度
                currWidth = i - stack.peek() - 1;
                //两边最低的柱子高度减去中间柱子长度即为坑洼地高度
                currHeight = Math.min(height[stack.peek()], height[i]) - height[mid];
                //坑洼面积 = 宽 * 高
                res += currHeight * currWidth;
            }
            //如果栈为空或当前柱子高度小于栈顶柱子高度，则继续寻找可以形成坑洼的右边柱子
            stack.push(i);
        }
        return res;
    }
}

/**
 * 双指针：双指针：当左指针柱子小于右指针柱子时，我们只需要关注左边，
 * 不用担心右边会不会漏水，因为至少右指针柱子可以挡住水。相反亦是如此。
 */
class Solution42_3 {
    public int trap(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}