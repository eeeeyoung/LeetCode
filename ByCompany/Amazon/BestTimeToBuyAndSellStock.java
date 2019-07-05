/**
 *https://leetcode.com/problems/best-time-to-buy-and-sell-stock/.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int plen = prices.length;
        int[] buyAt = new int[plen];
        int[] sellAt = new int[plen];

        buyAt[0] = -prices[0];
        sellAt[0] = 0;

        for (int i = 1; i < plen; i++) {
            buyAt[i] = Math.max(sellAt[i - 1] - prices[i], buyAt[i - 1]);
            sellAt[i] = Math.max(sellAt[i - 1], buyAt[i - 1] + prices[i]);
        }

        return Math.max(buyAt[plen - 1], sellAt[plen - 1]);
    }
}
