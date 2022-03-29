package niuke.bytedance;

import java.util.*;

/**
 * 特征提取
 * https://www.nowcoder.com/questionTerminal/5afcf93c419a4aa793e9b325d01957e2
 */
public class FeatureExtraction {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int N = cin.nextInt();
        while (N-- > 0) {
            int M = cin.nextInt();
            int res = 1;
            while (M-- > 0) {
                int n = cin.nextInt();
                while (n-- > 0) {
                    int x = cin.nextInt();
                    int y = cin.nextInt();
                    String key = x + " " + y;
                    map2.put(key, map1.getOrDefault(key, 0) + 1);
                    res = Math.max(res, map2.get(key));
                }
                map1.clear();
                map1.putAll(map2);
                map2.clear();
            }
            System.out.println(res);
        }
    }
}
