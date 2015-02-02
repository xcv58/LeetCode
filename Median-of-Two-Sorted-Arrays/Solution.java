public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        return (double)(findKSortedArrays(A, 0, B, 0, len / 2 + 1) + findKSortedArrays(A, 0, B, 0, len / 2 + len % 2)) / 2.0;
    }

    private int findKSortedArrays(int A[], int ai, int B[], int bi, int k) {
        if (A.length - ai > B.length - bi) {
            return this.findKSortedArrays(B, bi, A, ai, k);
        }

        if (A.length - ai == 0) {
            return B[bi + k - 1];
        }

        if (k == 1) {
            return Math.min(A[ai], B[bi]);
        }

        int k1 = Math.min((A.length - ai - 1), (k / 2 - 1));
        int k2 = k - k1 - 2;
        return A[ai + k1] > B[bi + k2] ? findKSortedArrays(A, ai, B, bi + k2 + 1, k - k2 - 1) : findKSortedArrays(A, ai + k1 + 1, B, bi, k - k1 - 1);
    }
}
