package niuke.top100;

import java.util.*;

class BM58_1 {
    ArrayList<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();

    public ArrayList<String> Permutation(String str) {
        boolean[] visited = new boolean[str.length()];
        recall(str, visited);
        return res;
    }

    private void recall(String str, boolean[] visited) {
        if (sb.length() == str.length()) {
            res.add(new String(sb));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (visited[i] || i > 0 && str.charAt(i) == str.charAt(i - 1) && !visited[i - 1]) {
                continue;
            }
            sb.append(str.charAt(i));
            visited[i] = true;
            recall(str, visited);
            sb.delete(sb.length() - 1, sb.length());
            visited[i] = false;
        }
    }
}

class BM58_2 {
    ArrayList<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();

    public ArrayList<String> Permutation(String str) {
        dfs(str.toCharArray(), 0);
        return res;
    }

    private void dfs(char[] arr, int depth) {
        if (depth == arr.length) {
            res.add(new String(arr));
            return;
        }
        HashSet<Character> set = new HashSet<>(); // 同一层不能使用同一个数两次
        for (int i = depth; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            swap(arr, i, depth);
            dfs(arr, depth + 1);
            swap(arr, i, depth);
            set.add(arr[i]);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


