import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        traverse(root, rst, 0);
        Collections.reverse(rst);
        return rst;
        
    }

    // traverse from the root of the binary tree, the level represents the depth of each node
    // the hashmap stores the depth, list of those nodes of the same depth pair
    public void traverse(TreeNode root, List<List<Integer>> r, int level) {
        if(root==null) {
            return ;
        }
        List<Integer> l;
        if(level==r.size()) {
            r.add(new ArrayList<Integer>());
        } 
        l = r.get(level);
        l.add(root.val);
        traverse(root.left, r, level+1);
        traverse(root.right, r, level+1);
    }
    
}
// @lc code=end

