#include <vector>
using namespace std;

class Solution {
public:
  int findMin(vector<int> &num) {
    int i = 0;
    for (int j = num.size() - 1, mid = (i + j) / 2; i < j; mid = (i + j) / 2) {
      if (num[i] < num[j]) {
        break;
      }
      if (num[mid] > num[j]) {
        i = mid + 1;
      } else if (num[mid] == num[j]) {
        i++;
        j--;
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
