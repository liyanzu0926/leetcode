package test;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        int sum = list.stream().mapToInt(x -> x).sum();
        System.out.println(sum);
        for (Integer integer : list) {

        }

    }
}


