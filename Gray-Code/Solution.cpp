#include <vector>

using namespace std;

class Solution {
public:
  vector<int> grayCode(int n) {
    vector<int> result;
    if (n == 0) {
      result.push_back(0);
    } else {
      result = grayCode(n - 1);
      for (int i = result.size() - 1; i >= 0; i--) {
        result.push_back((1 << (n - 1)) + result[i]);
      }
    }
    return result;
  }
};

int main() {
  return 0;
}
