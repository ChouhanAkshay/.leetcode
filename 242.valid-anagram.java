/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int count[] = new int[26];

        for(char ch : s.toCharArray())
        {
            count[ch - 'a']++;
        }
        for(char ch : t.toCharArray())
        {
            count[ch - 'a']--;
        }
        for(int c : count)
        {
            if(c!=0)
                return false;
        }

        return true;
    }
}
// @lc code=end

