package leetcode;

public class Lc160 {

}

public class Solution160_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int m = 0;
        int n = 0;
        while (p != null){
            m++;
            p = p.next;
        }
        while (q != null){
            n++;
            q = q.next;
        }
        int gap;
        if (m > n){
            p = headA;
            q = headB;
            gap = m - n;
        }else {
            p = headB;
            q = headA;
            gap = n - m;
        }
        while (gap > 0){
            p = p.next;
            gap--;
        }
        while (p !=null && q != null){
            if (p == q){
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}

