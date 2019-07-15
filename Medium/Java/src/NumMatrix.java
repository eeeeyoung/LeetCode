public class NumMatrix {
    private int[][] sum = null;

    public NumMatrix(int[][] matrix) {
        int numRow = matrix.length, numCol = matrix[0].length;
        sum = new int[numRow + 1][numCol + 1];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                sum[r + 1][c + 1] = sum[r + 1][c] + sum[r][c + 1] + matrix[r][c] - sum[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
