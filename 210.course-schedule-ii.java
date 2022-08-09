/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    int[] indegree;
    int[] rst;
    HashMap<Integer, HashSet<Integer>> mem = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();
    int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        rst = new int[numCourses];
        indegree = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            HashSet<Integer> neighbors = mem.getOrDefault(to, new HashSet<Integer>());
            if(neighbors.add(from)) {
                indegree[from] += 1;
            }
            mem.put(to, neighbors);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int next = queue.pollFirst();
            seen.add(next);
            rst[index++] = next;
            HashSet<Integer> neighbors = mem.getOrDefault(next, new HashSet<Integer>());
            for(int neighbor: neighbors) {
                if(seen.contains(neighbor)) {
                    continue;
                }
                indegree[neighbor] -= 1;
                if(indegree[neighbor]==0) {
                    queue.add(neighbor);
                }
            }
        }
        return index!=numCourses ? new int[0] : rst;
    }
}
// @lc code=end

