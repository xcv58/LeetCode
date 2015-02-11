class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        first = 0
        second = 0
        for i in A:
            first = (first ^ i) & ~second
            second = (second ^ i) & ~first
        return first
