package leetcode;

public class Lc235 {

}

class Solution235_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else{
                break;
            }
        }
        return root;
    }
}
