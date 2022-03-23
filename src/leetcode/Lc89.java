package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc89 {
}

/**
 * 格雷编码
 * 规律
 * n = 0   n = 1   n = 2   n = 3
 *  0        0       00      000
 *           1       01      001
 *                   11      011
 *                   10      010
 *                           110
 *                           111
 *                           101
 *                           100
 *
 *  n = i的格雷编码为 n = i - 1 的格雷编码加上 n = i - 1 的格雷编码的镜像高位添 1
 */
class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0); // 首位一定为0
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0 ; j--) {
                list.add(head + list.get(j));
            }
            head <<= 1; // 负责给高位添 1
        }
        return list;
    }
}
