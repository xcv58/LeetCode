#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int majorityElement(vector<int> &num) {
        int index = 0;
        for (int count = 1, i = 0; i < num.size(); i++, count = max(count, 1)) {
            count += num[index] == num[i] ? 1 : -1;
            index = count == 0 ? i : index;
        }
        return num[index];
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
