class Solution:
    # @param obstacleGrid, a list of lists of integers
    # @return an integer
    def uniquePathsWithObstacles(self, obstacleGrid):
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        board = [[0 for x in xrange(n)] for x in xrange(m)]
        board[0][0] = 1 - obstacleGrid[0][0]

        for i in xrange(m):
            for j in xrange(n):
                board[i][j] += (1 - obstacleGrid[i][j]) * ((0 if i == 0 else board[i - 1][j]) + (0 if j == 0 else board[i][j - 1]))
        return board[m - 1][n - 1]
