package test;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        String str = "12:24";
        String s = str.toLowerCase();
        System.out.println(s);
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> lmap = new LinkedHashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Collection<Integer> values = map.values();
        String[] split = str.split(":");
        System.out.println(Arrays.toString(split));
        
    }
}



