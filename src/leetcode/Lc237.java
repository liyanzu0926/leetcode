package leetcode;

public class Lc237 {
}

class Solution237_1 {
    public void deleteNode(ListNode node) {
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}

class Solution237_2 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
