package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/26 10:29
 */
public class Offer028 {
}

class Solution028_1 {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    /**
     * @return 尾结点
     */
    private Node dfs(Node head){
        Node cur = head;
        Node last = null;
        // 遍历链表，直到尾结点
        while(cur != null){
            Node next = cur.next;
            if(cur.child != null){
                last = dfs(cur.child);
                // 将cur结点与child结点相连
                cur.next = cur.child;
                cur.child.prev = cur;
                // 将child的尾结点与cur的next结点相连
                if(next != null){
                    last.next = next;
                    next.prev = last;
                }
                cur.child = null;
            }else{
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
