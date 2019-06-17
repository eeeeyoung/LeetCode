/**
 * https://leetcode.com/problems/perfect-squares/.
 *
 * Given a positive integer n,
 * find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 */
public class DPPerfectSquares {

    public int numSquares(int n) {
        // init and base
        int minNum, tmp;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // Recursion
        for (int i = 2; i <= n; i++) {
            minNum = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                tmp = dp[i - j * j] + 1;
                if (minNum > tmp) {
                    minNum = tmp;
                }
            }
        }
        return dp[n];
    }
}
