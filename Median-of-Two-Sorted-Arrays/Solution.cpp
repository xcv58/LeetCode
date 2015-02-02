#include <iostream>

class Solution {
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        double result = (double)findkMinSortedArrays(A, 0, m, B, 0, n, (m + n) / 2 + 1) / 2.0;
        return result + ((m + n) % 2 == 0 ? ((double)findkMinSortedArrays(A, 0, m, B, 0, n, (m + n) / 2) / 2.0) : result);
    }

    int findkMinSortedArrays(int A[], int ai, int m, int B[], int bi, int n, int k) {
        if (m - ai > n - bi) {
            return findkMinSortedArrays(B, bi, n, A, ai, m, k);
        }

        if (m - ai == 0) {
            return B[bi + k - 1];
        }

        if (k == 1) {
            return A[ai] < B[bi] ? A[ai] : B[bi];
        }

        int k1 = (k / 2 > m - ai) ? (m - ai - 1) : (k / 2 - 1);
        int k2 = k - k1 - 2;

        if (A[ai + k1] == B[bi + k2]) {
            return A[ai + k1];
        }

        if (A[ai + k1] > B[bi + k2]) {
            return findkMinSortedArrays(A, ai, m, B, bi + k2 + 1, n, k - k2 - 1);
        }

        return findkMinSortedArrays(A, ai + k1 + 1, m, B, bi, n, k - k1 - 1);

    }
};

int main() {
    int A[] = {1, 2};
    int B[] = {1, 2};
    Solution s;
    double result = s.findMedianSortedArrays(A, 2, B, 2);
    printf("%f\n", result);
    return 0;
}
