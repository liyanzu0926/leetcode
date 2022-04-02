package niuke.top100;

import leetcode.TreeNode;

import java.util.*;

/**
 * 层次遍历
 */
class BM39_1 {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#");
                sb.append(" ");
            } else {
                sb.append(node.val);
                sb.append(" ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString().trim();
    }

    TreeNode Deserialize(String str) {
        String[] strArray = str.split(" ");
        if (strArray.length == 0 || strArray[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (i < strArray.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i + 1 < strArray.length && !strArray[i + 1].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(strArray[i + 1]));
                queue.offer(node.left);
            }
            i++;
            if (i + 1 < strArray.length && !strArray[i + 1].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(strArray[i + 1]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

}
