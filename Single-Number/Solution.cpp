#include "stdio.h"

class Solution {
public:
  int singleNumber(int A[], int n) {
    int result = 0;
    for (int i = 0; i < n; i++) {
      result ^= A[i];
    }
    return result;
  }
};

int main() {
  Solution s;
  int A[] = {1, 2, 2, 3, 1};
  int result = s.singleNumber(A, sizeof(A) / sizeof(A[0]));
  printf("%d\n", result);
  return 0;
}
