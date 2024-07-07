/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {
            int m = (low + high) / 2;

            int part = getPart(nums,m);

            if(part > k){
                low = m + 1;
            } else{
                high = m - 1;
            }
        }
        return low;
    }

    public int getPart(int[] a , int m) {
        int part = 1;
        int sum = 0;

        for(int i = 0 ; i < a.length ; i++) {
            if(sum + a[i] <= m) {
                sum += a[i]; 
            } else {
                part ++;
                sum = a[i];
            }
        }

        return part;
    }
}
// @lc code=end

