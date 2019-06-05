import java.util.Map;
import java.util.HashMap;

/**
 *
 * https://leetcode.com/problems/number-of-corner-rectangles/.
 *
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.
 *
 * A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle.
 * Note that only the corners need to have the value 1.
 * Also, all four 1s used must be distinct.
 *
 */
public class DPNumberofCornerRectangles {
    /**
     * Progressively adding rows.
     * At each addition, increment the number of rectangles stored at
     * row-pairs in "counts" HashMap
     * @param grid the input grid consisting of 1 and 0 bits
     * @return the number of total rectangles
     */
    public int countCornerRectangles(int[][] grid) {

        // Initializations
        HashMap<Integer, Integer> counts = new HashMap<>();
        int ans, c;
        ans = 0;

        for (int i = 0; i < grid.length; i++) {
            // iterating through rows

            for (int a = 0; a < grid[i].length; a++) {
                // first number of the pair

                if (grid[i][a] == 1) {

                    for (int b = a + 1; b < grid[i].length; b++) {
                        // second number of the pair

                        if (grid[i][b] == 1) {
                            c = counts.getOrDefault(getPos(a, b), 0);

                            // for each previous rectangles formed by this a,
                            // b pair, there will be one more given a new base
                            ans += c;
                            counts.put(getPos(a, b), c + 1);
                        }
                    }
                } else {
                    // Do nothing
                    assert true;
                }
            }
        }

        return ans;
    }

    private static int getPos(int a, int b){
        return 201 * a + b;
    }
}
