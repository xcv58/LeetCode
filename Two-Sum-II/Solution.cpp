#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        for (int i = 0, j = numbers.size() - 1, gap; i < j; j = gap > 0 ? j - 1 : j, i = gap > 0 ? i : i + 1) {
            gap = numbers[i] + numbers[j] - target;
            if (gap == 0) { return {i + 1, j + 1}; }
        }
        return {-1, -1};
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
