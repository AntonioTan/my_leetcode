/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> mem = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            mem.add(new HashSet<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            mem.get(from).add(to);
        }
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> firstCourses = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            if(mem.get(i).size()==0) {
                seen.add(i);
                firstCourses.add(i);
            }
        }
        int remNum = numCourses;
        while(!firstCourses.isEmpty()) {
            List<Integer> secondCourses = new ArrayList<>();
            remNum -= firstCourses.size();
            for(int i=0; i<numCourses; i++) {
                if(seen.contains(i)) {
                    continue;
                }
                HashSet<Integer> prerequisiteSet = mem.get(i);
                for(int j=0; j<firstCourses.size(); j++) {
                    prerequisiteSet.remove(firstCourses.get(j)); 
                }
                if(prerequisiteSet.size()==0) {
                    seen.add(i);
                    secondCourses.add(i);
                }
            }
            firstCourses = secondCourses;
        }
        return remNum==0;
    }
}
// @lc code=end

