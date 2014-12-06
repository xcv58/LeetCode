#include <vector>

using namespace std;

class Solution {
public:
    int findPeakElement(const vector<int> &num) {
        for (int i = 0, j = num.size() - 1, mid = j / 2; i < j; mid = (i + j) / 2) {
            if (mid == i) {
                return num[mid] > num[j] ? mid : j;
            }
            i = num[mid] < num[mid + 1] ? mid : i;
            j = num[mid] > num[mid + 1] ? mid : j;
        }
        return 0;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
