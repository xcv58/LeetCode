public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int n = matrix[0].length;

        for (int x, y, i = 0, j = matrix.length * n, mid; i < j; ) {
            mid = (i + j) / 2;
            x = mid / n;
            y = mid % n;

            if (matrix[x][y] == target) {
                return true;
            }
            if (target < matrix[x][y]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}
