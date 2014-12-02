public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        return Math.abs(s.length() - t.length()) <= 1 && isOneEditDistance(s, 0, t, 0);
    }

    public boolean isOneEditDistance(String s, int si, String t, int ti) {
        if (si == s.length() || ti == t.length()) {
            return s.length() - si + t.length() - ti == 1;
        }

        if (s.charAt(si) == t.charAt(ti)) {
            return isOneEditDistance(s, si + 1, t, ti + 1);
        } else {
            return isSame(s, si + (s.length() - si >= t.length() - ti ? 1 : 0), t, ti + (t.length() - ti >= s.length() - si ? 1 : 0));
        }
    }

    public boolean isSame(String s, int si, String t, int ti) {
        if (si == s.length() || ti == t.length()) {
            return s.length() - si + t.length() - ti == 0;
        }
        return (s.charAt(si) == t.charAt(ti)) && isSame(s, si + 1, t, ti + 1);
    }
}
