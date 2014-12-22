#include <string>

using namespace std;

class Solution {
public:
    string convertToTitle(int n) {
        return n <= 0 ? "" : convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
