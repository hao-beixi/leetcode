import java.util.Arrays;

/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        // nums = [1, 2, 3, 4]
        System.out.println(Arrays.toString(nums));
        int[] preProduct = new int[nums.length];
        preProduct[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++)
            preProduct[i] = preProduct[i - 1] * nums[i];
        // preProduct = [1, 2, 6, 24]
        // preProduct = [1, 1*2, 1*2*3, 1*2*3*4]

        System.out.println(Arrays.toString(preProduct));
        int[] postProduct = new int[nums.length];
        postProduct[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--)
            postProduct[i] = postProduct[i+1] * nums[i];
        System.out.println(Arrays.toString(postProduct));
        // postProduct = [24, 24, 12, 4]
        // postProduct = [1*2*3*4, 2*3*4, 3*4, 4]

        int[] ans = new int[nums.length];
        ans[0] = postProduct[1];
        
        ans[nums.length - 1] = preProduct[nums.length - 2];
        
        for(int i = 1; i < nums.length - 1; i++) {
            ans[i] = preProduct[i - 1] * postProduct[i + 1];
        }
        // ans = [2*3*4, (1)*(3*4), (1*2) * 4, 1*2*3]
        // ans = [24, 12, 8, 6]
        return ans;
    }

}
// @lc code=end

