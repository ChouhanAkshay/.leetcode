/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;

        for(int i = 0 ; i< weights.length ; i++){
            high+= weights[i];
            low = Math.max(low, weights[i]);
        }

        if(days == 1) {
            return high;
        }

        while(low <= high){
            int mid = (low + high ) / 2;

            int sum = calculateCap(weights, mid);

            if(sum <= days){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int calculateCap(int[] weights, int cap){
        int days = 1; //First day.
        int load = 0;
        int n = weights.length; //size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1; //move to next day
                load = weights[i]; //load the weight.
            } else {
                //load the weight on the same day.
                load += weights[i];
            }
        }
        return days;
    }
}
// @lc code=end

