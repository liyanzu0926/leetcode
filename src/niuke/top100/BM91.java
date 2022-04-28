package niuke.top100;

import java.util.*;


public class BM91 {

    public String solve (String str) {
        // write code here
        char[] sArr = str.toCharArray();
        int len = sArr.length;
        for(int i = 0; i < len / 2; i++){
            char temp = sArr[i];
            sArr[i] = sArr[len - 1 - i];
            sArr[len - 1 - i] = temp;
        }
        return new String(sArr);
    }
}
