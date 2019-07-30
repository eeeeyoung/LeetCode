import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/.
 */
public class ThreeSumClosest {
    /**
     * Given an array nums of n integers and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     *
     * You may assume that each input would have exactly one solution.
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int arrlen = nums.length;
        int diff = Integer.MAX_VALUE, closest = 0;
        int i, j, k, targetSum, tempSum;
        for (i = 0, j = i + 1, k = arrlen - 1;
             i < arrlen - 2;
             i++) {
            targetSum = target - nums[i];
            while (j < k) {
                tempSum = nums[j] + nums[k];
                if (Math.abs(tempSum - targetSum) < diff) {
                    diff = Math.abs(tempSum - targetSum);
                    closest = nums[i] + tempSum;
                }

                if ((tempSum - targetSum) > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closest;
    }
}
