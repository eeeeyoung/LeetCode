import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    private int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null) return res;
        int roLength = matrix.length;
        int coLength = matrix[0].length;

        Queue<int[]> PQueue = new LinkedList<>();
        Queue<int[]> AQueue = new LinkedList<>();
        boolean[][] pacific = new boolean[roLength][coLength];
        boolean[][] atlantic = new boolean[roLength][coLength];

        for (int i = 0; i < roLength; i++) {
            PQueue.offer(new int[]{i, 0});
            PQueue.offer(new int[]{i, coLength - 1});
            pacific[i][0] = true;
            pacific[i][coLength - 1] = true;
        }
        for (int j = 0; j < coLength; j++) {
            AQueue.offer(new int[]{0, j});
            AQueue.offer(new int[]{roLength - 1, j});
            atlantic[0][j] = true;
            atlantic[roLength - 1][j] = true;
        }
        bfs(matrix, PQueue, pacific);
        bfs(matrix, AQueue, atlantic);
        for (int i = 0; i < roLength; i++) {
            for (int j = 0; j < coLength; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i); temp.add(j);
                if (atlantic[i][j] && pacific[i][j]) res.add(temp);
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][]visited) {
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
