class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        anchor = m
        i = 0
        j = 0
        while i < m or j < n:
            if i == m or j == n:
                while j < n:
                    A[anchor] = B[j]
                    j += 1
                    anchor += 1
                    anchor %= m + n
                break
            if A[i] < B[j]:
                A[anchor] = A[i]
                i += 1
            else:
                A[anchor] = B[j]
                j += 1
            anchor += 1
            anchor %= m + n

        self.copy(A, m , m + n, B, 0)
        self.copy(A, 0, m, A, n)
        self.copy(B, 0, n, A, 0)
        return


    def copy(self, src, start, end, dest, destIndex):
        j = destIndex + (end - start - 1)
        for i in reversed(range(start, end)):
            dest[j] = src[i]
            j -= 1
        return

# this problem is not for Python
