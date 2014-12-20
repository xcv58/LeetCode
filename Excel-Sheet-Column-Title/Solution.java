public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        for (; n != 0; n /= 26) {
            sb.append((char)('A' + (--n % 26)));
        }
        return sb.reverse().toString();
    }
}
