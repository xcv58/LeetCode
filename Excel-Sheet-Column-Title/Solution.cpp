#include <string>

using namespace std;

class Solution {
public:
    string convertToTitle(int n) {
        if (n == 0) { return ""; }
        char c = --n % 26 +'A';
        return convertToTitle(n / 26) + c;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
