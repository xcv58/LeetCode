public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] minBoard = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                minBoard[i][j] = grid[i][j] + this.min(minBoard, i, j);
            }
        }
        return minBoard[grid.length - 1][grid[0].length - 1];
    }

    private int min(int[][] minBoard, int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (i == 0 || j == 0) {
            return minBoard[i - (i > 0 ? 1 : 0)][j - (j > 0 ? 1 : 0)];
        }
        return minBoard[i][j - 1] < minBoard[i - 1][j] ? minBoard[i][j - 1] : minBoard[i - 1][j];
    }
}
