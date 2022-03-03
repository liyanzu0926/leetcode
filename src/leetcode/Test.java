package leetcode;


import java.io.*;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] v = new int[5];
        for (int i = 0; i < 3; i++) {
            f(v);
            System.out.println(Arrays.toString(v));
        }
    }

    private static void f(int[] v) {
        for (int i = 0; i < v.length; i++) {
            v[i] += 1;
        }
    }


}

