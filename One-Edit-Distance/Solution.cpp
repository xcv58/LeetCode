#include <string>

using namespace std;

class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        for (int i = 0; i < min(s.size(), t.size()); i++) {
            if (s.at(i) != t.at(i)) {
                return s.substr(i + (s.size() >= t.size() ? 1 : 0)).compare(t.substr(i + (s.size() <= t.size() ? 1 : 0))) == 0;
            }
        }
        return s.size() - t.size() == 1 || s.size() - t.size() == -1;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
