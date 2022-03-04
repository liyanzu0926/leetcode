package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc94 {
    public static void main(String[] args) {


    }
}

/**
 * 递归
 */
class Solution94_1 {
    List<Integer> inrderList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return inrderList;
        inorderTraversal(root.left);
        inrderList.add(root.val);
        inorderTraversal(root.right);
        return inrderList;
    }
}

/**
 * 非递归
 */
class Solution94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> valueList = new ArrayList<>();
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        while (root != null || !nodeStack.isEmpty()){
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            valueList.add(root.val);
            root = root.right;
        }
        return valueList;
    }
}


