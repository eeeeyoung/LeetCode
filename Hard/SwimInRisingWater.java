import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/swim-in-rising-water/.
 */
public class SwimInRisingWater {
    // 2 <= N <= 50
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int N = grid.length;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(hashFunc(new int[]{0, 0}));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        int res = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int[] sq = pq.poll();
            int x = sq[0], y = sq[1], elev = sq[2];
            res = Math.max(elev, res);

            if (x == N - 1 && y == N - 1) {
                return res;
            }

            for (int i = 0; i < 4; i++) {
                if (0 <= x + dr[i] && x + dr[i] <= N - 1 &&
                    0 <= y + dc[i] && y + dc[i] <= N - 1) {
                    int[] co = new int[]{x + dr[i], y + dc[i], grid[x + dr[i]][y + dc[i]]};
                    if (!pq.contains(co) && !visited.contains(hashFunc(co))) {
                        pq.offer(co);
                        visited.add(hashFunc(co));
                    }
                }
            }
        }
        return -1;
    }

    private int hashFunc(int[] coordinate) {
        return 51 * coordinate[0] + coordinate[1];
    }
}
