#include <vector>
using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();

        vector<vector<int> > board(m, vector<int>(n));
        board[0][0] = 1 - obstacleGrid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] += (1 - obstacleGrid[i][j]) * ((i > 0 ? board[i - 1][j] : 0) + (j > 0 ? board[i][j - 1] : 0));
            }
        }

        return board[m - 1][n - 1];
    }
};
int main() {
  return 0;
}
