package niuke.top100;

import java.util.*;


public class BM52 {
    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        int xor = array[0];
        for (int i = 1; i < array.length; i++) {
            xor ^= array[i];
        }
        // 求最右边的1
//         int mask = xor & -xor;
        int mask = xor - (xor & (xor - 1));
        int x1 = 0;
        int x2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & mask) == 0) {
                x1 ^= array[i];
            } else {
                x2 ^= array[i];
            }
        }
        if (x2 < x1) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        return new int[]{x1, x2};
    }
}
