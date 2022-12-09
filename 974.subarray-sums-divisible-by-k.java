/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modCounts = new int[k];
        int sum = 0;
        for(int x : nums) {
            sum += x;
            sum %= k;
            if(sum < 0) sum += k;
            modCounts[sum]++; 
        }
        int count = 0;
        for(int x : modCounts)
            count += (x * (x - 1)) / 2;
    
        return count + modCounts[0];
    }
}
// @lc code=end

