/**
 * https://leetcode.com/problems/maximum-product-subarray/.
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        int l = nums.length;

        if (l == 1) {
            return nums[0];
        }

        // Init
        int max, min, result, tmp;

        // Base
        max = nums[0];
        min = nums[0];
        result = nums[0];

        // Recursion
        for (int i = 1; i < l; i++) {
            tmp = max;
            max = LCUtility.maxOf3(max * nums[i], min * nums[i], nums[i]);
            min = LCUtility.minOf3(tmp * nums[i], min * nums[i], nums[i]);
            result = max > result ? max : result;
        }

        return result;
    }
}
