#include <algorithm>
#include <vector>
#include <map>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        vector<string> result;
        map<string, int> map;
        for (int i = 0; i < strs.size(); i++) {
            string str = strs[i];
            sort(str.begin(), str.end());
            if (map.find(str) == map.end()) {
                map[str] = -i;
            } else {
                if (map[str] <= 0) {
                    result.push_back(strs[-map[str]]);
                    map[str] = i + 1;
                }
                result.push_back(strs[i]);
            }
        }
        return result;
    }
};

int main() {
  return 0;
}
