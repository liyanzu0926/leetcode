package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class TreeUtils {
    public static TreeNode createTree(Integer[] root, int index){
//        if (root.length == 0 || root[0] == null) return null;
//        Deque<TreeNode> queue = new LinkedList<>();
        if (index >= root.length){
            return null;
        }
        if (root[index] == null) return null;
        TreeNode treeNode = new TreeNode(root[index]);
        treeNode.left = createTree(root, 2 * index + 1);
        treeNode.right = createTree(root, 2 * index + 2);
        return treeNode;
    }
}
