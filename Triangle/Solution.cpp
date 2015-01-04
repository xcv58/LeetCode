#include <vector>

using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        vector<int> result = triangle[triangle.size() - 1];
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                result[j] = triangle[i][j] + min(result[j], result[j + 1]);
            }
        }
        return result[0];
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
