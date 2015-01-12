#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> list;
        if (n == 1) {
            list.push_back("()");
        }

        for (int i = 1; i < n - 1; i++) {
            vector<string> leftVector = generateParenthesis(i);
            vector<string> rightVector = generateParenthesis(n - i - 1);
            for (int j = 0; j < leftVector.size(); j++) {
                for (int k = 0; k < rightVector.size(); k++) {
                    list.push_back("(" + leftVector[j] + ")" + rightVector[k]);
                }
            }
        }

        if (n > 1) {
            vector<string> tmp = generateParenthesis(n - 1);
            for (int i = 0; i < tmp.size(); i++) {
                list.push_back("(" + tmp[i] + ")");
                list.push_back("()" + tmp[i]);
            }
        }

        return list;
    }
};

int main() {
  return 0;
}
