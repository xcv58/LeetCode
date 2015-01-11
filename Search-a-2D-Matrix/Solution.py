class Solution:
    # @param matrix, a list of lists of integers
    # @param target, an integer
    # @return a boolean
    def searchMatrix(self, matrix, target):
        if len(matrix) == 0:
            return False
        n = len(matrix[0])
        i = 0
        j = n * len(matrix)
        while i < j:
            mid = (i + j) / 2
            x = mid / n
            y = mid % n
            if matrix[x][y] == target:
                return True
            if matrix[x][y] > target:
                j = mid
            else:
                i = mid + 1
        return False
