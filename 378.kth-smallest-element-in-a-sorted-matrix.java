/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // use priority queue to maintain a queue of size k
        int M = matrix.length, N = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> -n1+n2);
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                int num = matrix[i][j];
                if(queue.size()==k) {
                    if(queue.peek()>num) {
                        queue.poll();
                        queue.add(num);
                    } else {
                        continue;
                    }
                } else {
                    queue.add(num);
                }
            }
        }
        return queue.peek();
    }
}
// @lc code=end

