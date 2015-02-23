#include <vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int result = 0;
        for (int i = 0, low = INT_MAX; i < prices.size(); i++) {
            low = min(low, prices[i]);
            result = max(result, prices[i] - low);
        }
        return result;
    }
};

int main() {
  return 0;
}
