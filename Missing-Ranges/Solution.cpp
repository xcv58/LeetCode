#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> findMissingRanges(int A[], int n, int lower, int upper) {
        vector<string> missList;

        for (int i = 0, previous = lower - 1, current = upper; i <= n; i++, previous = current) {
            current = (i == n) ? (upper + 1) : A[i];
            if (current - previous >= 2) {
                missList.push_back(getStr(previous + 1, current - 1));
            }
        }

        return missList;
    }

    string getStr(int i, int j) {
        return i == j ? to_string(i) : to_string(i) + "->" + to_string(j);
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
