class Solution {
public:
    bool isPalindrome(int x) {
        int update = 0;
        for (int tmp ; update < x; update = tmp, x /= 10) {
            tmp = (10 * update) + (x % 10);
            if (tmp == update) {
                return false;
            }
            if (tmp == x) {
                return true;
            }
        }
        return update == x;
    }
};
int main() {
  return 0;
}
