package niuke.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BM22 {
    public int compare(String version1, String version2) {
        // write code here
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            int x1 = Integer.parseInt(v1[i]);
            int x2 = Integer.parseInt(v2[i]);
            if (x1 < x2) {
                return -1;
            } else if (x1 > x2) {
                return 1;
            }
            i++;
        }
        while (i < v1.length) {
            if (Integer.parseInt(v1[i++]) != 0) {
                return 1;
            }
        }
        while (i < v2.length) {
            if (Integer.parseInt(v2[i++]) != 0) {
                return -1;
            }
        }
        return 0;
    }
}
