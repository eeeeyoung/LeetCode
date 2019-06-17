import java.util.List;

/**
 * https://leetcode.com/problems/triangle/.
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 */
public class DPTriangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        // init
        int numTriangles = triangle.size();
        int[] prev = new int[numTriangles];
        int[] curr = new int[numTriangles];

        // base
        prev[0] = triangle.get(0).get(0);

        // recursion
        for (int i = 1; i < numTriangles; i++) {

            curr[0] = prev[0] + triangle.get(i).get(0);

            for (int j = 1; j < i; j++) {
                curr[j] = Math.min(prev[j - 1], prev[j]) + triangle.get(i).get(j);
            }

            curr[i] = prev[i - 1] + triangle.get(i).get(i);

            System.arraycopy(curr, 0, prev, 0, i + 1);
        }

        // get min from curr
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numTriangles; i++) {
            min = curr[i] < min ? curr[i] : min;
        }
        return min;
    }
}
