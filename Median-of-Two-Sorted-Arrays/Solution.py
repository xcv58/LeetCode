class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        length = len(A) + len(B)
        result = self.findKSortedArrays(A, 0, B, 0, length / 2 + 1) / 2.0
        return result + (self.findKSortedArrays(A, 0, B, 0, length / 2) / 2.0 if length % 2 == 0 else result)

    def findKSortedArrays(self, A, ai, B, bi, k):
        if len(A) - ai > len(B) - bi:
            return self.findKSortedArrays(B, bi, A, ai, k)
        if len(A) - ai == 0:
            return B[bi + k - 1]
        if k == 1:
            return min(A[ai], B[bi])

        k1 = len(A) - ai - 1 if k / 2 > len(A) - ai else k / 2 - 1
        k2 = k - k1 - 2

        if A[ai + k1] == B[bi + k2]:
            return A[ai + k1]
        if A[ai + k1] > B[bi + k2]:
            return self.findKSortedArrays(A, ai, B, bi + k2 + 1, k - k2 - 1)
        return self.findKSortedArrays(A, ai + k1 + 1, B, bi, k - k1 - 1)
