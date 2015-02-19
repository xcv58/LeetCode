class Solution {
public:
    int removeDuplicates(int A[], int n) {
        int anchor = 0;

        for (int i = 0; i < n; i++, anchor++) {
            for (; i + 1 < n && A[i] == A[i+1]; i++);
            if (i + 1 < n) {
                A[anchor + 1] = A[i + 1];
            }
        }
        return anchor;
    }
};

int main() {
  return 0;
}
