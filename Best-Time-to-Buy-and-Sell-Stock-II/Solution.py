class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        return sum([y - x for x, y in zip(prices[0:-1], prices[1:]) if x < y])
