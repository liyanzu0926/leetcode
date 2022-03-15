package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Lc297 {
    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, null, null, 4, 5};
        TreeNode treeBylevelOrder = TreeUtils.createTreeBylevelOrder(root);
        Codec codec = new Codec();
        TreeNode newRoot = codec.deserialize(codec.serialize(treeBylevelOrder));


    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("*");
            } else {
                sb.append(node.val);
            }
            sb.append(" ");
            if (node != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] serialize = data.split(" ");
        if (serialize.length == 0 || serialize[0].equals("*")) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(serialize[0]));
        queue.offer(root);
        int index = 0;
        int len = serialize.length;
        while (index < len){
            TreeNode node = queue.poll();
            if (index + 1 < len && !serialize[index + 1].equals("*")){
                node.left = new TreeNode(Integer.parseInt(serialize[index + 1]));
                queue.offer(node.left);
            }
            index++;
            if (index + 1 < len && !serialize[index + 1].equals("*")){
                node.right = new TreeNode(Integer.parseInt(serialize[index + 1]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}
