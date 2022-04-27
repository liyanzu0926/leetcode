package niuke.top100;

import java.util.*;


public class BM88 {

    public boolean judge(String str) {
        // write code here
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
