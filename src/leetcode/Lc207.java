package leetcode;

import java.util.*;

public class Lc207 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {2, 3}, {3, 1}, {1, 3}};
        System.out.println(new Solution207_1().canFinish(numCourses, prerequisites));
    }
}

/**
 * 拓扑排序
 */
class Solution207_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 0) return true;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            map.put(prerequisites[i][1], map.getOrDefault(prerequisites[i][1], 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(prerequisites[i][0]) && !stack.contains(prerequisites[i][0])) {
                stack.push(prerequisites[i][0]);
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            int k = stack.pop();
            count++;
            if (count == numCourses - 1) return true;
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][0] == k) {
                    int num = map.get(prerequisites[i][1]) - 1;
                    map.put(prerequisites[i][1], num);
                    if (num == 0) {
                        stack.push(prerequisites[i][1]);
                        map.remove(prerequisites[i][1]);
                    }
                }
            }
        }
        System.out.println(count);
        return false;
    }
}

/**
 * 逆拓扑排序
 */
class Solution207_2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 0) return true;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            map.put(prerequisites[i][0], map.getOrDefault(prerequisites[i][0], 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(prerequisites[i][1]) && !stack.contains(prerequisites[i][1])) {
                stack.push(prerequisites[i][1]);
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            int k = stack.pop();
            count++;
            System.out.println(k);
            if (count == numCourses - 1) return true;
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == k) {
                    int num = map.get(prerequisites[i][0]) - 1;
                    map.put(prerequisites[i][0], num);
                    if (num == 0) {
                        stack.push(prerequisites[i][0]);
                        map.remove(prerequisites[i][0]);
                    }
                }
            }
        }
        System.out.println(count);
        return false;
    }
}
