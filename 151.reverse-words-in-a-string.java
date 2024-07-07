/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        //check if only one word
        //if more than one add to last 
        String temp = "";
        String ans = "";

        int low = 0;
        int high = s.length() - 1;

        while(low <= high){
            char c = s.charAt(low);

            // System.out.println(c != ' ');
            if(c != ' '){
                temp += c;
            } else if(ans != "" && temp != ""){
                ans = temp + " " + ans;
                temp = "";
            } else if(temp != ""){
                ans = temp;
                temp = "";
            }
             
            low++;
        }

        // System.out.println(ans);

        if(temp !=  ""){
            if(ans != ""){
                ans = temp + " " + ans;
            } else {
                ans = temp;
            }
        }
        return ans;
    }
}
// @lc code=end

