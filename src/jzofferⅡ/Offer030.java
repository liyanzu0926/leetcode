package jzofferⅡ;

import java.util.*;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/27 10:04
 */
public class Offer030 {
}

class RandomizedSet030_1 {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet030_1() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randomNum = random.nextInt(list.size());
        return list.get(randomNum);
    }
}

