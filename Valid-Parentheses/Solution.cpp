#include <stack>
#include <string>

using namespace std;
class Solution {
public:
  bool isValid(string s) {
    stack<char> charStack;
    for (int i = 0; i < s.length(); i++) {
      char c = s.at(i);
      if (isLeft(c)) {
        charStack.push(c);
        continue;
      }
      if (charStack.empty() || notMatch(charStack.top(), c)) {
        return false;
      }
      charStack.pop();
    }
    return charStack.empty();
  }

private:
  bool isLeft(char c) {
    return c == '(' || c == '{' || c == '[';
  }

  bool notMatch(char c, char d) {
    return !((c == '(' && d == ')') || (c == '{' && d == '}') || (c == '[' && d == ']'));
  }
};

int main() {
  return 0;
}
