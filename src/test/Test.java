package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();
        list.addFirst(123);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add((List<Integer>) list);
    }
}
