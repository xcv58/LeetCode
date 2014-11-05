#include <stdio.h>
#include <vector>

class Solution {
public:
  int findMin(std::vector<int> &num) {
    int i = 0;
    for (int j = num.size() - 1, mid = (i + j) / 2; num[i] > num[j]; mid = (i + j) / 2) {
      if (num[mid] > num[i]) {
        i = mid;
      } else if (num[mid] == num[i]) {
        return num[j];
      } else {
        j = mid;
      }
    }
    return num[i];
  }
};

int main() {
  return 0;
}
