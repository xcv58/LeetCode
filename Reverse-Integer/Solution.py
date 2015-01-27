class Solution:
    # @return an integer
    def reverse(self, x):
        if (x < 0):
            return -1 * self.reverse(-x)
        result = x % 10
        rest = x / 10
        limit = 2147483647 / 10
        while rest > 0:
            if result > limit:
                return 0
            result *= 10
            result += rest % 10
            rest /= 10
        return result
