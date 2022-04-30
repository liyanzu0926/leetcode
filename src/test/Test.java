package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[][] arr = {{2, 1}, {4, 2}, {3, 2}};
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(arr));
    }
}