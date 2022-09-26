package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/26 10:30
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(Node prev, Node next) {
        this.prev = prev;
        this.next = next;
    }

    public Node(Node prev, Node next, Node child) {
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

}
