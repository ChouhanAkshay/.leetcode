/*
 * @lc app=leetcode id=1539 lang=java
 *
 * [1539] Kth Missing Positive Number
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 1;
        int high = arr.length + k;

        // for(int i = 0 ; i < arr.length ; i ++) {
        //     high = Math.max(arr[i], high);
        // }

        high = high  + k;

        while(low <= high) {
            int mid = (low + high) / 2;

            int diff = calculateDiff(arr, k, mid);

            if(diff == k) {
                return mid;
            } else if(diff < k) {
                low = low + 1;
            } else {
                high = high - 1;
            }
        }

        return low;
    }

    public int calculateDiff(int[] a, int k, int mid){
        int diff = 0;

        for(int i = 0 ; i < a.length ; i ++) {
            if(a[i] <= mid) {
                diff++;
            }
        }

        return mid - diff;
    }
}
// @lc code=end

