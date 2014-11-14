class Solution:
    # @return a list of integers
    def grayCode(self, n):
        return [0] if n == 0 else self.grayCode(n - 1) + [(1 << n - 1) + x for x in reversed(self.grayCode(n - 1))]
