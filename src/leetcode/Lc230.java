package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Lc230 {
}

class Solution230_1 {
    private int res = -1;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null || res != -1) {
            return;
        }
        inorder(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }
}

class Solution230_2 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        int res = -1;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                res = root.val;
                break;
            }
            root = root.right;
        }
        return res;
    }
}

class Solution230_3 {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int kthSmallest(TreeNode root, int k) {
        countNodeNum(root);
        while (root != null){
            int left = map.getOrDefault(root.left, 0);
            if (left < k - 1){
                root = root.right;
                k = k - 1 - left;
            }else if (left > k - 1){
                // 左子树结点数量是多少就是多少，而右子树结点数量要加上左子树总的数量
                root = root.left;
            }else {
                break;
            }
        }
        return root.val;
    }

    private int countNodeNum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = countNodeNum(root.left);
        int right = countNodeNum(root.right);
        map.put(root, left + right + 1);
        return map.get(root);
    }
}
