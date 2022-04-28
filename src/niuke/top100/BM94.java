package niuke.top100;

import java.util.*;


class BM94_1 {

    public long maxWater(int[] arr) {
        // write code here
        int len = arr.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = arr[0];
        rightMax[len - 1] = arr[len - 1];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
            rightMax[len - 1 - i] = Math.max(rightMax[len - i], arr[len - 1 - i]);
        }
        int area = 0;
        for (int i = 0; i < len; i++) {
            area += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return area;
    }
}

class BM94_2 {

    public long maxWater(int[] arr) {
        // write code here
        Deque<Integer> stack = new LinkedList<>();
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int right = i;
                int height = Math.min(arr[left], arr[right]) - arr[top];
                int width = right - left - 1;
                area += height * width;
            }
            stack.push(i);
        }
        return area;
    }
}

class BM91_3 {

    public long maxWater(int[] arr) {
        // write code here
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int leftMax = 0;
        int rightMax = 0;
        int area = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if (arr[left] < arr[right]) {
                area += leftMax - arr[left];
                left++;
            } else {
                area += rightMax - arr[right];
                right--;
            }
        }
        return area;
    }
}
