package leetcode;


import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 3, 2};
        System.out.println(Arrays.equals(a, b));
        HashMap<int[], Integer> map = new HashMap<>();
        map.put(a, 1);
        System.out.println(map.containsKey(b));

    }
}