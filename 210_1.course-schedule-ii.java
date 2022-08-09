import java.lang.management.PlatformLoggingMXBean;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    enum Color {
        WHITE, GREY, BLACK
    };
    HashMap<Integer, Color> colorMap = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> adjacentMap = new HashMap<>();
    int[] TopologicalOrder;
    int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        TopologicalOrder = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            colorMap.put(i, Color.WHITE);
        }
        for(int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            HashSet<Integer> arr = adjacentMap.getOrDefault(from, new HashSet<Integer>());
            arr.add(to);
            adjacentMap.put(from, arr);
        }
        for(int i=0; i<numCourses; i++) {
            if(!dfs(i)) {
               return new int[0]; 
            }
        }
        return TopologicalOrder;
    }
    public boolean dfs(int target) {
        if(colorMap.get(target)==Color.BLACK) {
            return true;
        }
        colorMap.put(target, Color.GREY);
        for(int neighbor: adjacentMap.getOrDefault(target, new HashSet<Integer>())) {
            if(colorMap.get(neighbor)==Color.WHITE) {
                if(!dfs(neighbor)) {
                    return false;
                }
            } else if(colorMap.get(neighbor)==Color.GREY) {
                return false;
            }
        }
        TopologicalOrder[index++] = target;
        colorMap.put(target, Color.BLACK);
        return true;
    }
}
// @lc code=end

