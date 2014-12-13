class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        result = 0
        i = 0
        anchor = 0
        length = len(prices)
        while i < length:
            while i + 1 < length and prices[i + 1] <= prices[i]:
                i += 1
            if prices[i] < prices[anchor]:
                anchor = i
            while i + 1 < length and prices[i + 1] >= prices[i]:
                i += 1
            result = max(prices[i] - prices[anchor], result)
            i += 1
        return result
