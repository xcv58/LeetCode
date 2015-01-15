#include <vector>
#include <string>
#include <iostream>
#include <sstream>

using namespace std;

class Solution {
public:
    string largestNumber(vector<int> &num) {
        sort(num.begin(), num.end(), compare);
        string result;
        for (auto s : num) { result += to_string(s); }
        int pos = 0;
        for (; result[pos] == '0' && pos + 1 < result.size(); pos++);
        return result.substr(pos);
    }

private:
    static bool compare(int x, int y) {
        stringstream s1, s2;
        s1 << x << y; s2 << y << x;
        return s1.str() > s2.str();
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
