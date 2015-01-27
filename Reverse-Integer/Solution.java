public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return -1 * this.reverse(-x);
        }

        int result = x % 10;
        for (int rest = x / 10, limit = Integer.MAX_VALUE / 10; rest > 0;) {
            if (limit < result) {
                return 0;
            }
            result *= 10;
            result += rest % 10;
            rest /= 10;
        }

        return result;
    }
}
