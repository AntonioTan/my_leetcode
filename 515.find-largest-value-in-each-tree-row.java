/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        traverse(root, 0);
        for(int key: map.keySet()) {
            rst.add(map.get(key));
        }
        return rst;
    }
    public void traverse(TreeNode root, int level) {
        if(root==null) {
            return ;
        }
        if(map.containsKey(level)) {
            int last = map.get(level);
            if(root.val>last) {
                map.put(level, root.val);
            }
        } else {
            map.put(level, root.val);
        }
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }
}
// @lc code=end

