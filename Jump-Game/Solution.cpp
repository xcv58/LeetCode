#include <iostream>

using namespace std;

class Solution {
public:
    bool canJump(int A[], int n) {
        int reach = 1;
        for (int i = 0; i < reach && reach <= n; i++) {
            reach = max(i + 1 + A[i], reach);
        }
        return reach >= n;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
