/**
 * LeetCode: https://leetcode.com/problems/max-increase-to-keep-city-skyline/.
 * @author Yang YI
 */
public class MaxIncreasetoKeepCitySkyline {
    /**
     * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are
     * allowed to increase the height of any number of buildings, by any amount (the amounts can be different for
     * different buildings). Height 0 is considered to be a building as well.
     *
     * At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right,
     * must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles
     * formed by all the buildings when viewed from a distance. See the following example.
     *
     * What is the maximum total sum that the height of the buildings can be increased?
     * @param grid The input grid
     * @return the maximum number of increases allowed
     */
    public static int MaxIncreaseKeepingSkyline(int[][] grid) {
        int numCol = grid[0].length;
        int numRow = grid.length;

        Integer[] Top = new Integer[numCol];
        Integer[] Left = new Integer[numRow];

        for (int i = 0; i < numRow; i++) {
            int max = -1;
            for (int j = 0; j < numCol; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            Left[i] = max;
        }

        for (int j = 0; j < numCol; j++) {
            int max = -1;
            for (int i = 0; i < numRow; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            Top[j] = max;
        }
        int max = 0;
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                max += Math.min(Top[i], Left[j]) - grid[i][j];
            }
        }
        System.out.println(max);
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4}, {2,4,5,7}, {9,2,6,3}, {0,3,1,0}};
        int i;
        i = MaxIncreaseKeepingSkyline(grid);
    }
}
