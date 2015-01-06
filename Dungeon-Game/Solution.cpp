#include <vector>

using namespace std;

class Solution {
public:
    int calculateMinimumHP(vector<vector<int> > &dungeon) {
        for (int i = dungeon.size() - 1; i >= 0; i--) {
            for (int j = dungeon[i].size() - 1; j >= 0; j--) {
                bool rowEnd = i == dungeon.size() - 1;
                bool columnEnd = j == dungeon[i].size() - 1;
                if (!rowEnd && !columnEnd) {
                    dungeon[i][j] -= min(dungeon[i + 1][j], dungeon[i][j + 1]);
                } else if (rowEnd ^ columnEnd) {
                    dungeon[i][j] -= dungeon[i + (rowEnd ? 0 : 1)][j + (columnEnd ? 0 : 1)];
                }
                dungeon[i][j] = dungeon[i][j] > 0 ? 0 : -dungeon[i][j];
            }
        }
        return dungeon[0][0] + 1;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
