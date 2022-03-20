package leetcode;

import java.util.*;

public class Lc621 {
}

class Solution621_1 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        // 存放剩余任务的信息，包括剩余数量和冷却时间
        List<int[]> taskInfo = new ArrayList<>();
        // 每一种任务初始化冷却时间为1
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            taskInfo.add(new int[]{entry.getValue(), 1});
        }
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++;
            // 如果最小冷却时间比time大，则让time更新为最小冷却时间，表示跳过这段阻塞时间
            time = Math.max(time, minCoolingTime(taskInfo));
            // 找到冷却时间小于等于time的剩余任务数最多的任务
            int bestTask = findMaxReaminTask(taskInfo, time);
            taskInfo.get(bestTask)[0]--;
            if (taskInfo.get(bestTask)[0] <= 0){
                taskInfo.remove(bestTask);
            }else {
                taskInfo.get(bestTask)[1] = time + n + 1;
            }
        }
        return time;
    }

    private int findMaxReaminTask(List<int[]> taskInfo, int time) {
        int maxIndex = -1;
        int maxTask = Integer.MIN_VALUE;
        for (int i = 0; i < taskInfo.size(); i++) {
            if (taskInfo.get(i)[1] <= time){
                if (taskInfo.get(i)[0] > maxTask){
                    maxTask = taskInfo.get(i)[0];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }

    private int minCoolingTime(List<int[]> taskInfo) {
        int min = Integer.MAX_VALUE;
        for (int[] info : taskInfo) {
            min = Math.min(min, info[1]);
        }
        return min;
    }
}

class Solution621_2 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        // 找到最多任务数
        for (char task : tasks) {
            int num = map.getOrDefault(task, 0) + 1;
            map.put(task, num);
            maxNum = Math.max(maxNum, num);
        }
        // 比如任务数最多的是A，3个，冷却时间 n = 2，则最少需要执行 AXX AXX A 次
        // 即（3 - 1） * （2 + 1） + 1 = 7
        int leastTime = (maxNum - 1) * (n + 1) + 1;

        //此时为了尽量利用X所预占的空间（贪心）使得整个执行序列长度尽量小，将剩余任务往X预占的空间插入
        //剩余的任务次数有两种情况：
        //1.与A出现次数相同，那么B任务最优插入结果是ABX ABX AB，中间还剩两个空位，当前序列长度+1
        //2.比A出现次数少，若还有X，则按序插入X位置，比如C出现两次，形成ABC ABC AB的序列
        //直到X预占位置还没插满，剩余元素逐个放入X位置就满足冷却时间至少为n

        // 统计最大次数任务的数量
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == maxNum){
                count++;
            }
        }
        // 更新最少执行时间(减一是因为上面已经加过一次最大任务数）int leastTime = (maxNum - 1) * (n + 1) + 1;
        leastTime = leastTime + count - 1;

        //当所有X预占的位置插满了怎么办？
        //在任意插满区间（这里是ABC）后面按序插入剩余元素，比如ABCD ABCD发现D之间距离至少为n+1，肯定满足冷却条件
        //因此，当X预占位置能插满时，最短序列长度就是task.length，不能插满则取最少预占序列长度

        return Math.max(leastTime, tasks.length);
    }
}
