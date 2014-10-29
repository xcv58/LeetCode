class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        result = 0
        for i in A:
            result = result ^ i;
        return result


A = [1, 2, 3, 2, 1]
solution = Solution();
print solution.singleNumber(A);
