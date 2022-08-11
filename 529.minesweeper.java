/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    int[][] diff = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
    int M, N;
    public char[][] updateBoard(char[][] board, int[] click) {
        M = board.length;
        N = board[0].length;
        boolean[][] mem = new boolean[M][N];
        for(int i=0; i<M; i++) {
            Arrays.fill(mem[i], false);
        }
        // bfs part
        LinkedList<int[]> queue = new LinkedList<>();
        if(board[click[0]][click[1]]=='M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        queue.add(click);
        mem[click[0]][click[1]] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] next = queue.pollFirst();
                int calMine = 0;
                LinkedList<int[]> temp = new LinkedList<>();
                for(int j=0; j<diff.length; j++) {
                    int newRow = next[0]+diff[j][0];
                    int newCol = next[1]+diff[j][1];
                    if(newRow<0 || newRow>=M || newCol<0 || newCol>=N) {
                        continue;
                    }
                    if(board[newRow][newCol]=='M') {
                        calMine += 1;
                    } else {
                        if(board[newRow][newCol]=='E' && !mem[newRow][newCol]) {
                            temp.add(new int[]{newRow, newCol});
                        }
                    }
                }
                if(calMine==0) {
                    board[next[0]][next[1]] = 'B';
                    for(int[] pos: temp) {
                        mem[pos[0]][pos[1]] = true;
                        queue.add(pos);
                    }
                } else {
                    board[next[0]][next[1]] = (char)('0'+calMine);
                }
            }
        }
        return board;
    }
}
// @lc code=end

