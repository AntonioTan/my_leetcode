/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    int M = 0, N = 0;
    int[][] diff = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int convert(int row, int col) {
        return row*N+col;
    }
    public boolean bfs(int row, int col, int[][] heights) {
        HashSet<Integer> seen = new HashSet<>();
        seen.add(convert(row, col));
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        boolean whetherAtlantic = false;
        boolean whetherPacific = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] next = queue.pollFirst();
                if(next[0]==0 || next[1]==0) {
                    whetherAtlantic = true;
                }
                if(next[0]==M-1 || next[1]==N-1) {
                    whetherPacific = true;
                }
                for(int j=0; j<diff.length; j++) {
                    int newRow = next[0]+diff[j][0];
                    int newCol = next[1]+diff[j][1];
                    if(newRow>=0 && newRow<M && newCol>=0 && newCol<N && !seen.contains(convert(newRow, newCol)) && heights[newRow][newCol]<=heights[next[0]][next[1]])  {
                        seen.add(convert(newRow, newCol));
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return whetherAtlantic && whetherPacific;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> rst = new ArrayList<>();
        M = heights.length;
        N = heights[0].length;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(bfs(i, j, heights)) {
                    rst.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }
        return rst;
    }
}
// @lc code=end

