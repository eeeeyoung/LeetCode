/**
 * https://leetcode.com/problems/minimum-falling-path-sum/.
 *
 * Given a square array of integers A,
 * we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row,
 * and chooses one element from each row.
 * The next row's choice must be in a column
 * that is different from the previous row's column by at most one.
 */
public class DPMinimumFallingPathSum {
    /**
     * DP. Try to think of it like Viterbi Decoding / Posterior Decoding,
     * At each level, can calculate all possible minimums up to this point, and
     * get the minimum from this level.
     *
     * Pass on.
     *
     * Space Complexity, two rows is sufficient, prev row and curr row.
     *
     * Time Complexity, one pass. O(N)
     *
     * @param A The input square array
     * @return the minimum sum
     */
    public int minFallingPathSum(int[][] A) {

        // Initializations
        int width = A[0].length;
        int[] prev = new int[width];
        int[] curr = new int[width];

        // Base case
        System.arraycopy(A[0], 0, prev, 0, width);

        // Looping
        for (int i = 1; i < A.length; i++) {

            // edge case 0
            curr[0] = Math.min(prev[0], prev[1]) + A[i][0];

            for (int j = 1; j < width - 1; j++) {
                curr[j] = Math.min(prev[j - 1], Math.min(prev[j], prev[j + 1])) + A[i][j];
            }

            // edge case width - 1
            curr[width - 1] =
                    Math.min(prev[width - 2], prev[width - 1]) + A[i][width - 1];

            // Termination of current loop of i-th row
            System.arraycopy(curr, 0, prev, 0, width);
        }

        // Get minimum value from last row
        int min = Integer.MIN_VALUE;
        for (int a = 0; a < width; a++) {
            min = min < curr[a] ? min : curr[a];
        }

        return min;
    }
}
