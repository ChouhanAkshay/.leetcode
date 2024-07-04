/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 */

// @lc code=start
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int i = 0 ; i< nums.length ; i++){
            high = Math.max(high,nums[i]);
        }

        while(low <=high){
            int mid = (low + high ) / 2;

            int sum = calculateSum(nums, mid);

            if(sum <= threshold){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int calculateSum(int[] a, int mid){
        int sum = 0;

        for(int i  = 0 ; i < a.length ; i++){
            sum += Math.ceil((double)a[i]/ (double)mid);
        }

        return sum;
    }
}
// @lc code=end