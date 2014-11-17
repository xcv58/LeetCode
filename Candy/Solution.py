class Solution:
    # @param ratings, a list of integer
    # @return an integer
    def candy(self, ratings):
        size = len(ratings)
        candy = [1] * size
        for i in xrange(size):
            self.check(ratings, candy, i, None)
        for i in reversed(range(size)):
            self.check(ratings, candy, i, None)
        return sum(candy)

    def check(self, ratings, candy, i, j):
        if j is None:
            self.check(ratings, candy, i, i - 1)
            self.check(ratings, candy, i, i + 1)
        else:
            candy[i] = candy[j] + 1 if (j >= 0 and j < len(ratings)) and ratings[i] > ratings[j] and candy[i] <= candy[j] else candy[i]
