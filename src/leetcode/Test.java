package leetcode;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Deque<Character> stack = new LinkedList<>();
        ArrayList<Character> st2 = new ArrayList<>();
        stack.push('a');
        stack.push('b');
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('b');
        String s1 = new String(String.valueOf(characters));
        System.out.println(s1);
        Object[] objects = stack.toArray();
//        for (int i = 0; i < objects.length; i++) {
//            System.out.println(objects[i]);
//        }
//        System.out.println(String.valueOf(stack));

    }
}