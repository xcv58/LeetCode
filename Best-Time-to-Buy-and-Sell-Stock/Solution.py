class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        result = 0
        low = None
        for i in prices:
            low = i if low == None else min(low, i)
            result = max(result, i - low)
        return result
