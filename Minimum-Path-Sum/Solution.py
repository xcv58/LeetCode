class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        if len(grid) == 0:
            return 0
        minBoard = [[0 for x in range(len(grid[0]))] for x in range(len(grid))]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                minBoard[i][j] = grid[i][j] + self.min(minBoard, i, j)
        return minBoard[len(grid) - 1][len(grid[0]) - 1]

    def min(self, minBoard, i, j):
        if i == 0 and j == 0:
            return 0
        if i == 0 or j == 0:
            return minBoard[i - (1 if i > 0 else 0)][j - (1 if j > 0 else 0)]
        return minBoard[i][j - 1] if minBoard[i][j - 1] < minBoard[i - 1][j] else minBoard[i - 1][j]
