/*
 * @lc app=leetcode id=764 lang=java
 *
 * [764] Largest Plus Sign
 */

// @lc code=start
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int rst = 0;
        int[][][] grid = new int[4][n][n];
        for(int i=0; i<4; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(grid[i][j], 1);
            }
        }
        for(int i=0; i<mines.length; i++) {
            int x = mines[i][0];
            int y = mines[i][1];
            for(int j=0; j<4; j++) {
                grid[j][x][y] = 0;
            }
        }
        for(int i=1; i<n; i++) {
            for(int j=0; j<n; j++) {
                // left
                if(grid[0][j][i]>0) {
                    grid[0][j][i] = Math.max(grid[0][j][i-1]+1, grid[0][j][i]);
                }
                // right
                if(grid[1][j][n-1-i]>0) {
                    grid[1][j][n-1-i] = Math.max(grid[1][j][n-1-i], grid[1][j][n-i]+1);
                }
                // top
                if(grid[2][i][j]>0) {
                    grid[2][i][j] = Math.max(grid[2][i][j], grid[2][i-1][j]+1);
                }
                // bot
                if(grid[3][n-1-i][j]>0) {
                    grid[3][n-1-i][j] = Math.max(grid[3][n-1-i][j], grid[3][n-i][j]+1);
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int min1 = Math.min(grid[0][i][j], grid[1][i][j]);
                int min2 = Math.min(grid[2][i][j], grid[3][i][j]);
                rst = Math.max(rst, Math.min(min1, min2));
            }
        }
        return rst;
    }
}
// @lc code=end

