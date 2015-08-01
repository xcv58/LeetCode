#include <string>

using namespace std;

class Solution {
public:
    bool isAnagram(string s, string t) {
        int c[256] = {};
        for (int i = 0; i < s.size(); i++) { c[s[i]]++; }
        for (int i = 0; i < t.size(); i++) { c[t[i]]--; }
        for (int i = 0; i < 256; i++) {
            if (c[i]) { return false; }
        }
        return true;
    }
};
