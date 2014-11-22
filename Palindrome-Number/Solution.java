public class Solution {
    public boolean isPalindrome(int x) {
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

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.isPalindrome(1000);
        System.out.println(b);
    }
}
