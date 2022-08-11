/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] mem = new int[n];
        int remNum = n;
        List<HashSet<Integer>> adjacentArr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjacentArr.add(new HashSet<Integer>());
        }
        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            adjacentArr.get(from).add(to);
            adjacentArr.get(to).add(from);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(adjacentArr.get(i).size()<=1) {
                leaves.add(i);
                mem[i] = 1;
            }
        }
        while(remNum>2) {
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<leaves.size(); i++) {
                int next = leaves.get(i);
                remNum -= 1;
                HashSet<Integer> arr = adjacentArr.get(next);
                for(int neighbor: arr) {
                    adjacentArr.get(neighbor).remove(next);
                    if(adjacentArr.get(neighbor).size()==1 && mem[neighbor]!=1) {
                        mem[neighbor] = 1;
                        temp.add(neighbor);
                    }
                }
            }
            leaves = temp;
        }
        return leaves;

    }
}
// @lc code=end

