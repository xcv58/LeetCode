#include <string>

using namespace std;

class Solution {
public:
    void reverseWords(string &s) {
        int j = 0, len = s.length();
        for (int i = 0, wordStart = 0; i < len; ) {
            for (; i < len && s[i] == ' '; i++);
            if (i == len) { break; }
            if (j > 0) { s[j++] = ' '; }
            wordStart = j;
            for (; i < len && s[i] != ' '; s[j++] = s[i++]);
            reverseWords(s, wordStart, j - 1);
        }
        s.resize(j);
        reverseWords(s, 0, j - 1);
    }

    void reverseWords(string &s, int i, int j) {
        for (; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
