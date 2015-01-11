#include <vector>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        if (matrix.size() == 0) {
            return false;
        }
        int n = matrix[0].size();

        for (int x, y, i = 0, j = matrix.size() * n, mid; i < j; ) {
            mid = (i + j) / 2;
            x = mid / n;
            y = mid % n;

            if (matrix[x][y] == target) {
                return true;
            }
            if (target < matrix[x][y]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
};

int main() {
  return 0;
}
