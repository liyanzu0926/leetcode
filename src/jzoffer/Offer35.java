package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/4 10:21
 */
public class Offer35 {
}

/**
 * @Description: 用map存放node的索引
 * @author: lyz
 * @date: 2022/8/4 10:22
 */
class Solution35_1 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node headNode = new Node(-1);
        Node r = headNode;
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            map.put(p, node);
            r.next = node;
            r = r.next;
            p = p.next;
        }
        p = head;
        r = headNode.next;
        while (p != null) {
            r.random = map.get(p.random);
            r = r.next;
            p = p.next;
        }
        return headNode.next;
    }
}

/**
 * @Description: 方法一的递归实现
 * @author: lyz
 * @date: 2022/8/4 10:27
 */
class Solution35_2 {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}

/**
 * @Description: 在每个结点后面插入一个结点的拷贝，则新插入结点的random就为当前结点的random.next
 * 最后再将所有新插入的结点从原链表中摘掉
 * @author: lyz
 * @date: 2022/8/4 11:05
 */
class Solution35_3 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 每个结点后面都插入一个新结点（值等于本结点）
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        // 将新结点的random指针连接起来
        p = head;
        Node q = p.next;
        while (p != null) {
            q.random = p.random == null ? null : p.random.next;
            p = q.next;
            if (p != null) {
                q = p.next;
            }
        }
        // 将所有新插入的结点挑出来
        p = head;
        q = p.next;
        Node headNew = q;
        while (p.next.next != null) {
            p.next = p.next.next;
            q.next = p.next.next;
            p = p.next;
            q = q.next;
        }
        p.next = null;
        q.next = null;
        return headNew;
    }
}
