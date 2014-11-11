#include <vector>
using namespace std;

class Solution {
public:
  vector<int> twoSum(std::vector<int> &numbers, int target) {
    vector<int> tmpNumbers(numbers);
    sort(tmpNumbers.begin(), tmpNumbers.end());

    vector<int> result;
    int num1 = 0;
    int num2 = 0;
    for (int i = 0, j = tmpNumbers.size() - 1, sum; i < j;) {
      sum = tmpNumbers[i] + tmpNumbers[j];
      if (sum == target) {
        num1 = tmpNumbers[i];
        num2 = tmpNumbers[j];
        break;
      }
      if (sum > target) {
        j--;
      } else {
        i++;
      }
    }

    for (int i = 0, j = 0; i < numbers.size(); i++) {
      int tmpInt = numbers[i];
      if (tmpInt == num1 || tmpInt == num2) {
        result.push_back(i + 1);
        j++;
      }
    }

    return result;
  }
};

int main() {
  return 0;
}
