#include <vector>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int result = 0;
        if (prices.size() == 0) { return result; }
        for (int i = 0; i < prices.size() - 1; i++) {
            result += max(prices[i + 1] - prices[i], 0);
        }
        return result;
    }
};
