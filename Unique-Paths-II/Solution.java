public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] board = new int[m][n];
        board[0][0] = 1 - obstacleGrid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] += (1 - obstacleGrid[i][j]) * ((i > 0 ? board[i - 1][j] : 0) + (j > 0 ? board[i][j - 1] : 0));
            }
        }

        return board[m - 1][n - 1];
    }
}
