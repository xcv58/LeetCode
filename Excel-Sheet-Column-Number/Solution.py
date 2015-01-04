class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        return reduce(lambda x, y : x * 26 + y, [ord(c) - 64 for c in list(s)])
