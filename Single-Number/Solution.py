class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        return reduce(lambda x,y:x^y,A)


A = [1, 2, 3, 2, 1]
solution = Solution();
print solution.singleNumber(A);
