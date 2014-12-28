class Solution:
    # @return an integer
    def numTrees(self, n):
        if n <= 1:
            return 1
        sum = 0
        for i in range(n):
            sum += self.numTrees(i) * self.numTrees(n - 1 - i)
        return sum
