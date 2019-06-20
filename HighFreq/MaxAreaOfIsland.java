/**
 * https://leetcode.com/problems/max-area-of-island/.
 */
public class MaxAreaOfIsland {
    private int n;
    private int m;

    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFS(i, j, grid);
                }
            }
        }
        return count;
    }

    private void DFS(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        DFS(i - 1, j, grid);
        DFS(i + 1, j, grid);
        DFS(i, j - 1, grid);
        DFS(i, j + 1, grid);
    }
}
