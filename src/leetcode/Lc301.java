package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc301 {
}

/**
 * BFS
 */
class Solution301_1 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> currSet = new HashSet<>();
        currSet.add(s);
        while (true){
            for (String str : currSet) {
                if (valid(str)){
                    res.add(str);
                }
            }
            if (res.size() > 0){
                return res;
            }
            Set<String> nextSet = new HashSet<>();
            for (String str : currSet) {
                for (int i = 0; i < str.length(); i++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)){
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')'){
                        nextSet.add(str.substring(0,i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }

    private boolean valid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                count++;
            }else if (str.charAt(i) == ')'){
                count--;
            }
            if (count < 0){
                return false;
            }
        }
        return count == 0;
    }
}





