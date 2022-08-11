/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    int[][] diff = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int M, N;
    public int[][] updateMatrix(int[][] mat) {
        M = mat.length;
        N = mat[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(mat[i][j]!=0) {
                    mat[i][j] = Integer.MAX_VALUE;
                } else {
                    seen.add(convert(i, j));
                    queue.add(new int[]{i, j});
                }
            }
        }
        return bfs(mat, queue, seen);
    }
    public int convert(int row, int col) {
        return row*N + col;
    }
    public int[][] bfs(int[][] mat, LinkedList<int[]> queue, HashSet<Integer> seen) {
        int distance = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] next = queue.pollFirst();
                for(int j=0; j<diff.length; j++) {
                    int newRow = next[0]+diff[j][0];
                    int newCol = next[1]+diff[j][1];
                    if(newRow<0 || newRow>=M || newCol<0 || newCol>=N) {
                        continue;
                    }
                    if(mat[newRow][newCol]==0) {
                        continue;
                    }
                    if(!seen.add(convert(newRow, newCol))) {
                        continue;
                    }
                    mat[newRow][newCol] = Math.min(mat[newRow][newCol], distance);
                    queue.add(new int[]{newRow, newCol});
                }
            }
            distance += 1;
        }
        return mat;
    }
}
// @lc code=end

