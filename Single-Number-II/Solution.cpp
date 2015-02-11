class Solution {
public:
    int singleNumber(int A[], int n) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < n; i++) {
            first = (first ^ A[i]) & ~second;
            second = (second ^ A[i]) & ~first;
        }
        return first;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
