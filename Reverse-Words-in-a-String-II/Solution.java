public class Solution {
    public void reverseWords(char[] s) {
        for (int i = 0, j = 0; i < s.length; i++) {
            for (j = i; i < s.length && s[i] != ' '; i++);
            reverse(s, j, i - 1);
        }
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int i, int j) {
        for (; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
}
