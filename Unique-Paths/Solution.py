class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        board = [[0 for x in xrange(n)] for x in xrange(m)]
        for i in xrange(m):
            for j in xrange(n):
                board[i][j] = (1 if (i == 0 or j == 0) else board[i - 1][j] + board[i][j - 1])
        return board[m - 1][n - 1]
