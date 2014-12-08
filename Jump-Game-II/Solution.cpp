class Solution {
public:
    int jump(int A[], int n) {
        int *cache = new int[n];
        for (int i = 0; i < n; cache[i] = 0, i++);
        for (int i = 0, reach = 1; i < n; i++) {
            int last = i + A[i] + 1;
            if (last > reach) {
                for (int j = reach; j < last && j < n; cache[j] = cache[i] + 1, j++);
                reach = last;
            }
        }
        return cache[n - 1];
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
