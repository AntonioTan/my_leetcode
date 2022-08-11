/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length, N = mat[0].length;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(mat[i][j]!=0) {
                    mat[i][j] = 10001;
                }
            }
        }
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(i>0) {
                    mat[i][j] = Math.min(mat[i-1][j]+1, mat[i][j]);
                }
                if(j>0) {
                    mat[i][j] = Math.min(mat[i][j-1]+1, mat[i][j]);
                }
            }
        }
        for(int i=M-1; i>=0; i--) {
            for(int j=N-1; j>=0; j--) {
                if(i<M-1) {
                    mat[i][j] = Math.min(mat[i+1][j]+1, mat[i][j]);
                }
                if(j<N-1) {
                    mat[i][j] = Math.min(mat[i][j+1]+1, mat[i][j]);
                }
            }
        }
        return mat;
    }
}
// @lc code=end

