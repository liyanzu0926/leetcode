package niuke.top100;

import java.util.*;


public class BM60 {
    ArrayList<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();

    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        recall(n, 0, 0);
        return res;
    }

    private void recall(int n, int left, int right) {
        if (sb.length() == 2 * n) {
            res.add(new String(sb));
            return;
        }
        if (left < n) {
            sb.append('(');
            recall(n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            recall(n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}