/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
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
    TreeMap<Integer, Integer> mem = new TreeMap<>((n1, n2)->n2-n1);
    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 0);
        return mem.firstEntry().getValue(); 
    }
    public void traverse(TreeNode root, int level) {
        if(root==null) {
            return ;
        }
        traverse(root.left, level+1);
        traverse(root.right, level+1);
        if(!mem.containsKey(level)) {
            mem.put(level, root.val);
        }
        
    }
}
// @lc code=end

