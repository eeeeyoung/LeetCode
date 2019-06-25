/**
 * https://leetcode.com/problems/game-of-life/.
 */
public class GameOfLife {
    private static final int[][] directions = {{-1, -1},
                                                {-1, 0},
                                                {-1, 1},
                                                {0, -1},
                                                {0, 1},
                                                {1, -1},
                                                {1, 0},
                                                {1, 1}};
    /**
     * Any live cell with fewer than two live neighbors dies
     * Any live cell with two or three live neighbors lives
     * Any live cell with more than three live neighbors dies
     * Any dead cell with exactly three live neighbors becomes a live cell
     * @param board prev state
     */
    public void gameOfLife(int[][] board) {
        // In place storing, with the following mapping:
        //      Prev       ->      Next
        //      dead(0)    ->      dead(2)
        //      dead(0)    ->      alive(3)
        //      alive(1)   ->      dead(4)
        //      alive(1)   ->      alive(5)
        //
        int rows = board.length;
        int cols = board[0].length;
        int[] map = new int[6];
        map[0] = 0;
        map[1] = 1;
        map[2] = 0;
        map[3] = 0;
        map[4] = 1;
        map[5] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                getAliveNeighbors(board, map, i, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2 || board[i][j] == 4) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3 || board[i][j] == 5) {
                    board[i][j] = 1;
                }
            }
        }
    }
    private void getAliveNeighbors(int[][] board, int[] map, int i, int j) {
        int aliveNeighbor = 0;
        int new_i, new_j;
        int rows = board.length;
        int cols = board[0].length;
        for (int[] d : directions) {
            new_i = i + d[0];
            new_j = j + d[1];
            if (new_i < 0 || new_i >= rows || new_j < 0 || new_j >= cols) {
                // pass
            } else {
                if (map[board[new_i][new_j]] == 1) aliveNeighbor++;
            }
        }

        if (aliveNeighbor < 2 && board[i][j] == 1) {
            board[i][j] = 4;
        } else if ((aliveNeighbor == 2 || aliveNeighbor == 3) && board[i][j] == 1) {
            board[i][j] = 5;
        } else if (aliveNeighbor > 3 && board[i][j] == 1) {
            board[i][j] = 4;
        } else if (board[i][j] == 0 && aliveNeighbor == 3) {
            board[i][j] = 3;
        } else {
            board[i][j] = 2;
        }
    }
}
