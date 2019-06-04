/**
 * https://leetcode.com/problems/maximum-subarray/.
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
public class DPMaxSubArray {

    public int maxSubArray(int[] nums) {

        int allTimeSum, curSum;
        allTimeSum = curSum = nums[0];;

        for (int i = 1; i < nums.length; i++) {
            // conditionally swaps allTimeMax and allTimeMin
            curSum = Math.max(curSum + nums[i], nums[i]);
            allTimeSum = Math.max(allTimeSum, curSum);
        }

        return allTimeSum;
    }
}
