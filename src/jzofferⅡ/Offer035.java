package jzofferⅡ;

import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/29 13:55
 */
public class Offer035 {
}

class Solution035_1 {
    public int findMinDifference(List<String> timePoints) {
        // 一共有24 * 60种可能的时间，超过24 * 60必然有重复的时间，则差值为0
        if(timePoints.size() > 24 * 60){
            return 0;
        }
        // 排序后最小时间差一定是两个相邻时间
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int preMinute = getMinute(timePoints.get(i - 1));
            int curMinute = getMinute(timePoints.get(i));
            res = Math.min(res, curMinute - preMinute);
        }
        // 首尾时间差，00:00和23：59只差1分钟
        // 需要将00：00加上24 * 60，然后求差
        res = Math.min(res, getMinute(timePoints.get(0)) + 24 * 60 - getMinute(timePoints.get(timePoints.size() - 1)));
        return res;
    }

    private int getMinute(String minute) {
        String[] arr = minute.split(":");
        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }
}
