/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/.
 */
public class DPMinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {

        // initializations
        int[] aggcost = new int[cost.length + 1];

        // base case
        aggcost[0] = 0;
        aggcost[1] = 0;

        // recursion
        for (int i = 2; i < cost.length + 1; i++) {
            aggcost[i] = Math.min(aggcost[i - 1] + cost[i - 1], aggcost[i - 2] + cost[i - 2]);
        }

        return aggcost[cost.length];
    }

    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs(cost2));
    }
}
