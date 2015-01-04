class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        result = triangle[-1]
        for i in reversed(range(len(triangle) - 1)):
            result = [node + min(left, right) for node, left, right in zip(triangle[i], result[:-1], result[1:])]
        return result[0]
