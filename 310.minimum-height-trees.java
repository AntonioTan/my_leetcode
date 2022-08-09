/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    // use map to construct adjacent edge matrix
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<=2) {
            List<Integer> rst = new ArrayList<>();
            for(int i=0; i<n; i++) {
                rst.add(i);
            }
            return rst;
        }
        List<HashSet<Integer>> mem = new ArrayList<>();
        for(int i=0; i<n; i++)  {
            mem.add(new HashSet<Integer>());
        }
        for(int i=0; i<edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            mem.get(from).add(to);
            mem.get(to).add(from);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(mem.get(i).size()==1) {
                leaves.add(i);
            }
        }
        int remNode = n;
        while(remNode>2){
            List<Integer> newLeaves = new ArrayList<>();
            for(int leave: leaves) {
                remNode -= 1;
                HashSet<Integer> link = mem.get(leave);
                for(int node: link) {
                    HashSet<Integer> temp = mem.get(node);
                    temp.remove(leave);
                    if(temp.size()==1) {
                        newLeaves.add(node);
                    }
                }
                leaves = newLeaves;
            }
        }
        return leaves;


    }
}
// @lc code=end

