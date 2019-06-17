/**
 * https://leetcode.com/problems/arithmetic-slices/.
 *
 * A sequence of number is called arithmetic if it consists of at least three elements
 * and if the difference between any two consecutive elements is the same.
 */
public class DPArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        // corner case handling
        if (A.length <= 2) {
            return 0;
        }

        // init
        int l = A.length;
        int[] dp = new int[l];

        // base case 0, 1
        dp[0] = 0;
        dp[1] = 0;

        // recursion
        int sum = 0;
        for (int i = 2; i < l; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            } else {
                dp[i] = 0;
                // pass
            }
        }
        return sum;
    }
}
