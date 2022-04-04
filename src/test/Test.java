package test;

import leetcode.LinkedListUtils;
import leetcode.ListNode;
import leetcode.TreeNode;
import leetcode.TreeUtils;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Test {
    public static void main(String[] args) {
        Car car = new BaoMaCarFactory().createCar();
        car.print();
        Car car1 = new BenChiCarFactory().createCar();
        car1.print();

    }
}