package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/26 13:56
 */
public class Offer029 {
}

class Solution029_1 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        // 链表为空
        if (head == null) {
            node.next = node;
            return node;
        }
        // 链表只有一个结点
        if (head.next == head) {
            node.next = head.next;
            head.next = node;
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.val <= insertVal && insertVal <= cur.val) {
                break;
            }
            if (pre.val > cur.val) {
                if (insertVal > pre.val || insertVal < cur.val) {
                    break;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        node.next = cur;
        pre.next = node;
        return head;
    }
}

class Solution029_2 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);

        // 链表为空
        if (head == null) {
            node.next = node;
            return node;
        }

        // 链表只有一个结点
        if (head.next == head) {
            node.next = head.next;
            head.next = node;
            return head;
        }

        Node p = head;
        while (p.val <= p.next.val && p.next != head) {
            p = p.next;
        }
        Node end = p;
        while (p.next.val < insertVal && p.next != end) {
            p = p.next;
        }
        // 如果p.next == end
        if (p.next.val < insertVal) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
        return head;
    }
}
