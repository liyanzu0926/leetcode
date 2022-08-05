package jzoffer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/5 10:49
 */
public class Offer37 {
}

/**
 * @Description: 层次遍历
 * @author: lyz
 * @date: 2022/8/5 11:08
 */
class Codec37_1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("# ");
            return sb.toString();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("# ");
            }
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        int len = arr.length;
        if (len == 0 || arr[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (i < len) {
            TreeNode node = queue.poll();
            if (i + 1 < len && !arr[i + 1].equals("#")) {
                node.left = new TreeNode(Integer.valueOf(arr[i + 1]));
                queue.offer(node.left);
            }
            i++;
            if (i + 1 < len && !arr[i + 1].equals("#")) {
                node.right = new TreeNode(Integer.valueOf(arr[i + 1]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}

/**
 * @Description: 前序遍历
 * @author: lyz
 * @date: 2022/8/5 11:14
 */
class Codec37_2 {

    // Encodes a tree to a single string.
    // 前序遍历序列化
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeByPreorder(root, sb);
        return sb.toString().trim();
    }

    private void serializeByPreorder(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val + " ");
        serializeByPreorder(root.left, sb);
        serializeByPreorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    // 前序遍历反序列化
    public TreeNode deserialize(String data) {
        String[] str = data.split(" ");
        List<String> list = new LinkedList<>(Arrays.asList(str));
        return deserializeByPreorder(list);
    }

    private TreeNode deserializeByPreorder(List<String> list) {
        if ("#".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.remove(0)));
        node.left = deserializeByPreorder(list);
        node.right = deserializeByPreorder(list);
        return node;
    }
}
