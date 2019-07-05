/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/.
 */
public class MostStonesRemovedwithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        // first retrieve minimum number of rows and columns
        int row = Integer.MIN_VALUE, col = Integer.MIN_VALUE;
        for (int[] stone : stones) {
            row = stone[0] > row ? stone[0] : row;
            col = stone[1] > col ? stone[1] : col;
        }

        // use memaddress as index in hashmap, assuming [0,0] has memaddress 0

    }
}
