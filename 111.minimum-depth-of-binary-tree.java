/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    int rst = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        track(root, 1);
        return rst;
    }
    public void track(TreeNode root, int level) {
        if(root==null) {
            return ;
        }
        if(root.left==null&&root.right==null) {
            rst = Math.min(rst, level);
        }
        track(root.left, level+1);
        track(root.right, level+1);
    }
}
// @lc code=end

