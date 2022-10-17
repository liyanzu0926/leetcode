package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/17 9:52
 */
public class Lc904 {
}

class Solution904_1 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) <= 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}

/**
 * @Description: 优化
 * 因为 0 <= fruits[i] < fruits.length，
 * 所以可以用一个长度为fruits.length的数组取代map
 * @author: lyz
 * @date: 2022/10/17 11:15
 */
class Solution904_2 {
    public int totalFruit(int[] fruits) {
        // 优化：
        // 0 <= fruits[i] < fruits.length
        int len = fruits.length;
        int[] count = new int[len];
        int num = 0;
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < fruits.length) {
            if (count[fruits[right]] == 0) {
                num++;
            }
            count[fruits[right]]++;
            while (num > 2) {
                count[fruits[left]]--;
                if (count[fruits[left]] <= 0) {
                    num--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
