/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Save leaf value to list respectively
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        track(l1, root1);
        track(l2, root2);
        // Compare two leaf lists check whether they are the same
        if(l1.size()!=l2.size()) return false;
        for(int i=0; i<l1.size(); i++) {
            if(l1.get(i)!=l2.get(i)) {
                return false;
            }
        }
        return true;
        
    }

    // List l is used to memorize values of leaf nodes, root is the root treenode of the binary tree
    public void track(List<Integer> l, TreeNode root) {
        if(root==null) {
            return ;
        }
        track(l, root.left);
        track(l, root.right);
        if(root.left==null&&root.right==null) {
            l.add(root.val);
        }
    } 
}
// @lc code=end

