#include <string>

using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
            for (; isSpecialChar(s.at(i)) && i < j; i++);
            for (; isSpecialChar(s.at(j)) && i < j; j--);
            if (tolower(s.at(i)) != tolower(s.at(j))) {
                return false;
            }
        }
        return true;
    }

    bool isSpecialChar(char c) {
        return c == '.' || c == '@' || c == '-' || c == '?' || c == '"' || c == '!' || c == '(' || c == ')' || c == '`' || c == ';' || c == ' ' || c == '?' || c == '#' || c == '\t' || c == ':' || c == ',' || c == '\'';
    }
};

int main() {
  return 0;
}
