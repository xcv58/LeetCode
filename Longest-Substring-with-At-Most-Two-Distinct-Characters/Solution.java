import java.util.*;

public class Solution {
    private static final int DISTINCT_NUM = 2;

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(getMaxLength(s, i), max);
        }
        return max;
    }

    private int getMaxLength(String s, int i) {
        HashSet<Character> set = new HashSet<Character>();
        int result = 0;
        for (int index = i; index < s.length(); index++) {
            set.add(s.charAt(index));
            if (set.size() > DISTINCT_NUM) { break; }
            result++;
        }
        return result;
    }
}
