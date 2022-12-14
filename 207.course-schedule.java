/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    enum Color {
        WHITE, GREY, BLACK
    }
    HashMap<Integer, Color> colorMap = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> adjacentMap = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i<numCourses; i++) {
            adjacentMap.put(i, new HashSet<Integer>());
            colorMap.put(i, Color.WHITE);
        }
        for(int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            adjacentMap.get(from).add(to);
        }
        for(int i=0; i<numCourses; i++) {
            if(!dfs(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int target) {
        if(colorMap.get(target)==Color.BLACK) {
            return true;
        }
        colorMap.put(target, Color.GREY);
        for(int neighbor: adjacentMap.get(target)) {
            if(colorMap.get(neighbor)==Color.WHITE) {
                if(!dfs(neighbor)) {
                    return false;
                }
            } else if (colorMap.get(neighbor)==Color.GREY) {
                return false;
            }
        }
        colorMap.put(target, Color.BLACK);
        return true;
    }
}
// @lc code=end

