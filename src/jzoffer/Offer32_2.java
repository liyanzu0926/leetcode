package jzoffer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author lyz
 * @Date 2022/7/21 11:11
 */
public class Offer32_2 {
}

class Solution32_2_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevelNodeNum = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            cur.add(node.val);
            curLevelNodeNum--;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(curLevelNodeNum == 0){
                res.add(cur);
                cur = new ArrayList<>();
                curLevelNodeNum = queue.size();
            }
        }
        return res;
    }
}
