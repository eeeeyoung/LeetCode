/**
 * https://leetcode.com/problems/max-area-of-island/.
 */
public class MaxAreaOfIsland {
    private int n;
    private int m;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int area;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    area = DFS(area, i, j, grid);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    private int DFS(int area, int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return area; // incompatible, return original area
        }
        grid[i][j] = 0;
        area++;
        area = DFS(area, i - 1, j, grid);
        area = DFS(area, i + 1, j, grid);
        area = DFS(area, i, j - 1, grid);
        area = DFS(area, i, j + 1, grid);
        return area;
    }
}
