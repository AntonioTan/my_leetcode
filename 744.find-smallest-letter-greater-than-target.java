/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int min = 0, max = letters.length-1;
        while(min<max) {
            int mid = (int)(min+max)/2;
            char letter = letters[mid];
            if(letter-target<=0) {
                min = mid+1;
            } else {
                max = mid;
            }
        }
        return letters[max]-target>0?letters[max]:letters[0];
    }
}
// @lc code=end

