import java.lang.Math;

/**
 * https://leetcode.com/problems/paint-house/.
 *
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on...
 * Find the minimum cost to paint all houses.
 */
public class DPPaintHouse {

    private static int INF = Integer.MAX_VALUE;
    /**
     * initialize 3 arrays to store the cumulative minimum cost to paint the nth house to be each of the 3 colours.
     * One pass of for loop. O(N)
     * @param costs initial 3 by n 2d array of costs as input
     * @return the minimum cost
     */
    public int minCost(int[][] costs) {

        int numHouses = costs.length;
        Integer[] red = new Integer[numHouses];  // 0
        Integer[] blue = new Integer[numHouses];   // 1
        Integer[] green = new Integer[numHouses];  // 2

        // Setting up base cases
        red[0] = costs[0][0];
        blue[0] = costs[0][1];
        green[0] = costs[0][2];

        // Main loop
        for (int i = 1; i < numHouses - 1; i++) {
            red[i] = Math.min(blue[i - 1] + costs[i][0], green[i - 1] + costs[i][0]);
            blue[i] = Math.min(red[i - 1] + costs[i][1], green[i - 1] + costs[i][1]);
            green[i] = Math.min(red[i - 1] + costs[i][2], blue[i - 1] + costs[i][2]);
        }

        return Math.min(red[numHouses - 1], Math.min(blue[numHouses - 1], green[numHouses - 1]));
    }

    public void main(int[] args) {
        int[][] input = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(input));
    }
}
