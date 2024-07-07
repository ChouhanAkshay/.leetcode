/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }
}
// @lc code=end

