class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        for (int anchor = m, i = 0, j = 0; i < m || j < n; anchor %= (m + n)) {
            if (i == m || j == n) {
                for (; j < n; anchor %= (m + n)) {
                    A[anchor++] = B[j++];
                }
                break;
            }
            A[anchor++] = A[i] < B[j] ? A[i++] : B[j++];
        }

        copy(A, m , m + n, B, 0);
        copy(A, 0, m, A, n);
        copy(B, 0, n, A, 0);
        return;
    }

private:
    void copy(int src[], int start, int end, int dest[], int destIndex) {
        for (int i = end - 1, j = destIndex + (end - start - 1); i >= start; i--, j--) {
            dest[j] = src[i];
        }
        return;
    }

};

int main(int argc, char *argv[]) {
    return 0;
}
