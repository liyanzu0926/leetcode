package jzoffer;

import java.util.*;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/5 17:12
 */
public class Offer38 {
}

class Solution38_1 {

    Set<String> res = new HashSet<>(); // set可以去重!!!
    StringBuffer cur = new StringBuffer();

    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[arr.length];
        recall(arr, visited);
        return res.toArray(new String[0]);
    }

    private void recall(char[] arr, boolean[] visited) {
        if (cur.length() == arr.length) {
            res.add(new String(cur));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            cur.append(arr[i]);
            visited[i] = true;
            recall(arr, visited);
            cur.deleteCharAt(cur.length() - 1);
            visited[i] = false;
        }
    }
}

class Solution38_2 {

    List<String> res = new ArrayList<>();
    StringBuffer cur = new StringBuffer();

    public String[] permutation(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr); // 排序
        boolean[] visited = new boolean[charArr.length];
        recall(charArr, visited);
        String[] arr = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void recall(char[] charArr, boolean[] visited) {
        if (cur.length() == charArr.length) {
            res.add(new String(cur));
            return;
        }
        for (int i = 0; i < charArr.length; i++) {
            // 当前下标已访问过 || 当前的元素charArr[i]与同一层的前一个元素charArr[i-1]相同
            // 且charArr[i-1]已经用过了
            // 对“已用过”的解释：对于以charArr[i]开头的子序列，如果charArr[i] == charArr[i - 1]
            // 且visited[i - 1] = false，说明以charArr[i - 1]开头的子序列出现过，
            // 这里的visited[i - 1] = false是回溯时由true变为fasle的
            // 而charArr[i] == charArr[i - 1]，相同值开头的序列需要舍弃后者
            if (visited[i] || i > 0 && charArr[i] == charArr[i - 1] && !visited[i - 1]) {
                continue;
            }
            cur.append(charArr[i]);
            visited[i] = true;
            recall(charArr, visited);
            cur.deleteCharAt(cur.length() - 1);
            visited[i] = false;
        }
    }
}
