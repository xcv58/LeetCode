class Solution {
public:
    int numTrees(int n) {
        int num [n + 1];
        num[0] = 1;

        for (int i = 1; i <= n; i++) {
            num[i] = 0;
            for (int j = 0; j < i; j++) {
                num[i] += num[j] * num[i - 1 - j];
            }
        }

        return num[n];
    }
};

int main() {
    return 0;
}
