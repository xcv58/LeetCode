import java.util.*;

public class Solution {
    private static final int DISTINCT_NUM = 2;

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); max = Math.max(getMaxLength(s, i), max), i++);
        return max;
    }

    private int getMaxLength(String s, int i) {
        HashSet<Character> set = new HashSet<Character>();
        int result = 0;
        for (int index = i; index < s.length() && set.size() <= DISTINCT_NUM; set.add(s.charAt(index)), index++, result++);
        return result - (set.size() > DISTINCT_NUM ? 1 : 0);
    }
}
