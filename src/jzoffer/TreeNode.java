package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/4 11:28
 */
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
