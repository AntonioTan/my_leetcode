/*
 * @lc app=leetcode id=306 lang=java
 *
 * [306] Additive Number
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        // get the first 2 numbers
        int N = num.length();
        for(int i=1; i<N-1; i++) {
            if(num.charAt(0)=='0'&&i>1) {
                break;
            }
            long firstNum = Long.valueOf(num.substring(0, i));
            for(int j=i+1; j<N; j++) {
                if(num.charAt(i)=='0'&&j>i+1) {
                    break;
                }
                long secondNum = Long.valueOf(num.substring(i, j));
                if(track(firstNum, secondNum, num, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // use the first numbers to check whether the rest of num string is additive number
    // int index from which the num string will be checked
    public boolean track(long firstNum, long secondNum, String num, int index) {
        long thirdNum = firstNum + secondNum;
        String thirdStr = String.valueOf(thirdNum);
        if(num.startsWith(thirdStr, index)) {
            if(thirdStr.length()+index==num.length()) {
                return true;
            } else {
                return track(secondNum, thirdNum, num, index+thirdStr.length());
            }
        } else {
            return false;
        }
    }
}
// @lc code=end

