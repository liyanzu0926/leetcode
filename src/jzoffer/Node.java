package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/4 10:22
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
