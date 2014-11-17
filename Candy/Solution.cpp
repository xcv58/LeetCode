#include <vector>

using namespace std;

class Solution {
public:
    int candy(vector<int> &ratings) {
        int size = ratings.size();
        vector<int> candyNum(size, 1);
        int result = 0;

        for (int i = 0; i < size; i++) {
            check(ratings, candyNum, i);
        }

        for (int i = size - 1; i >= 0; i--) {
            check(ratings, candyNum, i);
            result += candyNum[i];
        }
        return result;
    }

private:
    void check(vector<int> &ratings, vector<int> &candyNum, int i) {
        check(ratings, candyNum, i, i - 1);
        check(ratings, candyNum, i, i + 1);
    }

    void check(vector<int> &ratings, vector<int> &candyNum, int i, int j) {
        candyNum[i] = (j >= 0 && j < ratings.size()) && ratings[i] > ratings[j] && candyNum[i] <= candyNum[j] ? candyNum[j] + 1 : candyNum[i];
    }
};

int main() {
  return 0;
}
