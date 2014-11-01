#include "stdio.h"

class Solution {
public:
  int sqrt(int x) {
    int root = 1;
    int tmpInt = x;

    while (tmpInt > root) {
      root = root << 1;
      tmpInt = tmpInt >> 1;
    }

    for (int tmpResult, mid = (root + tmpInt) / 2; tmpInt +1 < root; mid = (root + tmpInt) / 2) {
      tmpResult = x / mid;
      if (tmpResult == mid) {
        return mid;
      } else if (tmpResult > mid) {
        tmpInt = mid;
      } else {
        root = mid;
      }
    }

    return tmpInt;
  }
};

int main() {
  Solution s;
  int arr[] = {0, 1, 2, 3, 100, 1024, 65536, 1579205274, 2147483647};
  for (int i = 0; i < sizeof(arr)/sizeof(arr[0]); i++) {
    printf("%d : %d\n", arr[i], s.sqrt(arr[i]));
  }
  return 0;
}
