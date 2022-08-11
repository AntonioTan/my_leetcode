/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    int[][] diff = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int M, N;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> rst = new ArrayList<>();
        M = heights.length;
        N = heights[0].length;
        boolean[][] pacific = new boolean[M][N];
        boolean[][] atlantic = new boolean[M][N];
        for(int i=0; i<M; i++) {
            Arrays.fill(pacific[i], false);
            Arrays.fill(atlantic[i], false);
        }
        for(int i=0; i<M; i++) {
            pacific = bfs(pacific, i, 0, heights);
            atlantic = bfs(atlantic, i, N-1, heights);
        }
        for(int i=0; i<N; i++) {
            pacific = bfs(pacific, 0, i, heights);
            atlantic = bfs(atlantic, M-1, i, heights);
        }
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(pacific[i][j]&&atlantic[i][j]) {
                    rst.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }
        return rst;
        
    }

    public boolean[][] bfs(boolean[][] mem, int row, int col, int[][] heights) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        mem[row][col] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] next = queue.pollFirst();
                for(int j=0; j<diff.length; j++) {
                    int newRow = next[0] + diff[j][0];
                    int newCol = next[1] + diff[j][1];
                    if(newRow<0 || newRow>=M || newCol<0 || newCol>=N) {
                        continue; 
                    }
                    if(mem[newRow][newCol]) {
                        continue;
                    }
                    if(heights[newRow][newCol]<heights[next[0]][next[1]]) {
                        continue;
                    }
                    mem[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return mem;
    }
}
// @lc code=end

