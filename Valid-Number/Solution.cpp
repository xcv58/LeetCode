#include "stdio.h"

class Solution {
public:
  bool isNumber(const char *s) {
    for (; *s != '\0'; s++) {
      if (*s != ' ') {
        break;
      }
    }

    bool plusOrMinus = false;
    bool dot = false;
    bool digital = false;
    bool exp = false;
    int num = 0;
    while (*s != '\0') {
      switch (*s) {
      case '+': case '-':
        if (plusOrMinus || digital) {
          return false;
        }
        plusOrMinus = true;
        break;
      case '.':
        if (dot) {
          return false;
        }
        dot = true;
        plusOrMinus = true;
        digital = false;
        break;
      case 'e': case 'E':
        if (exp || num == 0) {
          return false;
        }
        exp = true;
        dot = true;
        plusOrMinus = false;
        digital = false;
        break;
      case ' ':
        if ((exp && !digital) || num == 0) {
          return false;
        }
        for (s++; *s != '\0'; s++) {
          if (*s != ' ') {
            return false;
          }
        }
        return true;
      default:
        if (*s >= '0' && *s <= '9') {
          digital = true;
          num++;
        } else {
          return false;
        }
      }
      s++;
    }
    return (exp && digital) || (!exp && num > 0);
  }
};

int main() {
  Solution s;
  const char *str = "  123";
  bool result = s.isNumber(str);
  printf("%d\n", result);
  return 0;
}
