class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        anchor = 0
        i = 0
        while i < len(A):
            while i + 1 < len(A) and A[i] == A[i + 1]:
                i += 1
            if i + 1 < len(A):
                A[anchor + 1] = A[i + 1]
            anchor += 1
            i += 1
        return anchor
