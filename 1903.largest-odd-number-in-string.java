/*
 * @lc app=leetcode id=1903 lang=java
 *
 * [1903] Largest Odd Number in String
 */

// @lc code=start
class Solution {
    public String largestOddNumber(String num) {
        
        int high = num.length() - 1;

        while(high >= 0) {
            if(Integer.parseInt(String.valueOf(num.charAt(high))) % 2 != 0) {
                return num.substring(0,high + 1);
            }
            high --;
        }

        return "";
    }
}
// @lc code=end

