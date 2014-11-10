public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (i == 0 || j == 0) ? 1 : board[i - 1][j] + board[i][j - 1];
            }
        }
        return m + n <= 1 ? m + n : board[m - 1][n - 1];
    }
}
