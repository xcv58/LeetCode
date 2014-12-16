#include <stdio.h>
#include <string>
#include <stdlib.h>

using namespace std;
class Solution {
public:
    int compareVersion(string version1, string version2) {
        for (; version1 != version2; version1 = nextSubstr(version1), version2 = nextSubstr(version2)) {
            int gap = stoi(version1) - stoi(version2);
            if (gap != 0) {
                return gap > 0 ? 1 : -1;
            }
        }
        return 0;
    }

    string nextSubstr(string str) {
        for (int i = 0; i < str.size(); i++) {
            if (str.at(i) == '.') {
                return str.substr(i + 1);
            }
        }
        return "0";
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
