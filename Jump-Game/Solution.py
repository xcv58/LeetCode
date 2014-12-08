class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        reach = 1
        i = 0
        while i < reach and reach <= len(A):
            reach = max(reach, i + 1 + A[i])
            i += 1
        return reach >= len(A)
