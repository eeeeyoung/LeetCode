/**
 * https://leetcode.com/problems/coin-change/.
 */
public class CoinChange {
    /**
     * Return the fewest number of coins.
     * @param coins face value of coins
     * @param amount the target amount
     * @return number of coins
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];

        // base cases
        dp[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }

        // recursion
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (dp[i - coin] != -1) {
                        int num = dp[i - coin] + 1;
                        min = num < min ? num : min;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    dp[i] = -1;
                } else {
                    dp[i] = min;
                }
            }
        }
        return dp[amount];
    }
}
