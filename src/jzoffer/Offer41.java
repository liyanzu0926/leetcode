package jzoffer;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/8 12:04
 */
public class Offer41 {
}

class MedianFinder {
    // leftHeap存放小于等于中位数的数（较小的一半元素）
    // rightHeap存放大于中位数的数（较大的一半元素）
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a, b) -> (b - a));
        rightHeap = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        // 如果num小于等于左边最大的元素，说明num应该放在左边，
        // 同时也要保持左边和右边元素个数平衡（左边个数-右边个数<=1)
        if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
            leftHeap.offer(num);
            if (rightHeap.size() + 1 < leftHeap.size()) {
                rightHeap.offer(leftHeap.poll());
            }
        } else {
            rightHeap.offer(num);
            if (rightHeap.size() > leftHeap.size()) {
                leftHeap.offer(rightHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (leftHeap.size() == rightHeap.size()) {
            return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        } else {
            return leftHeap.peek();
        }
    }
}

