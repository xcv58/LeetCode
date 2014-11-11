#include <vector>
using namespace std;

class Solution {
public:
    int minPathSum(vector<std::vector<int> > &grid) {
        vector<std::vector<int> > minBoard;
        for (int i = 0; i < grid.size(); i++) {
            minBoard.push_back(vector<int>(grid[i].size(), 0));
        }
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                minBoard[i][j] = grid[i][j] + min(minBoard, i, j);
            }
        }

        return minBoard[grid.size() - 1][grid[0].size() - 1];
    }

    int min(vector<std::vector<int> > &minBoard, int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (i == 0 || j == 0) {
            return minBoard[i - (i > 0 ? 1 : 0)][j - (j > 0 ? 1 : 0)];
        }
        return minBoard[i][j - 1] < minBoard[i - 1][j] ? minBoard[i][j - 1] : minBoard[i - 1][j];
    }
};

int main() {
  return 0;
}
