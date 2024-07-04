/*
 * @lc app=leetcode id=1482 lang=java
 *
 * [1482] Minimum Number of Days to Make m Bouquets
 */

// @lc code=start
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // get min and max days
        int minDays = Integer.MAX_VALUE;
        int maxDays = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            minDays = Math.min(minDays, bloomDay[i]);
            maxDays = Math.max(maxDays, bloomDay[i]);
        }

        int low = minDays;
        int high = maxDays;

        if(bloomDay.length < (long)((long)m * (long)k)) {
            return -1;
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            int banqt = calculateBanqt(bloomDay, mid, k);

            if (banqt >= m) {
                high = mid  - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int calculateBanqt(int[] a, int mid, int k) {
        int bq = 0;
        int numOfFlowers = 0;

        for(int i = 0 ; i < a.length ; i++) {
            if(a[i] <= mid){
                numOfFlowers ++;
            } else {
                numOfFlowers = 0;
            }

            if(numOfFlowers == k) {
                bq ++;
                numOfFlowers = 0;
            }
        }

        return bq;
    }
}
// @lc code=end
