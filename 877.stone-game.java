/*
 * @lc app=leetcode id=877 lang=java
 *
 * [877] Stone Game
 */

// @lc code=start
class Solution {
    int[][] mem;
    public boolean stoneGame(int[] piles) {
        mem = new int[piles.length][piles.length];
        int total = 0;
        for(int i=0; i<piles.length; i++) {
            total += piles[i];
        }
        int alice_score = backtrack(piles, 0, piles.length-1, 0);
        return alice_score>total-alice_score;
    }
    public int backtrack(int[] piles, int start, int end, int index) {
        if(mem[start][end]!=0) {
            return mem[start][end];
        }
        if(start==end) {
            return piles[start];
        }
        int rst = 0;
        if(index%2==0) {
            rst = Math.max(
                piles[start]+backtrack(piles, start+1, end, index+1),
                piles[end]+backtrack(piles, start, end-1, index+1)
            );
        } else {
            rst = Math.max(
                backtrack(piles, start+1, end, index+1),
                backtrack(piles, start, end-1, index+1)
            );
        }
        mem[start][end] = rst;
        return mem[start][end];
    }
}
// @lc code=end

