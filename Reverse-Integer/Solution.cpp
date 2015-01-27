#include <limits>
using namespace std;

class Solution {
public:
    int reverse(int x) {
        if (x == numeric_limits<int>::min()) {
            return 0;
        }
        if (x < 0) {
            return -1 * reverse(-x);
        }
        int result = x % 10;
        for (int rest = x / 10, limit = numeric_limits<int>::max() / 10; rest > 0;) {
            if (limit < result) {
                return 0;
            }
            result *= 10;
            result += rest % 10;
            rest /= 10;
        }

        return result;
    }
};

int main() {
  return 0;
}
