import java.util.*;

public class Solution {
    private static final int DISTINCT_NUM = 2;

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] result = getMaxLength(s, i);
            max = Math.max(result[0], max);
            i += Math.max(result[0] - result[1] - 1, 0);
        }
        return max;
    }

    private int[] getMaxLength(String s, int i) {
        HashSet<Character> set = new HashSet<Character>();
        char c = s.charAt(i);
        int result[] = new int[2];
        for (int index = i; index < s.length(); index++, result[0]++, result[1]++) {
            set.add(s.charAt(index));
            if (set.size() > DISTINCT_NUM) {
                return result;
            }
            if (c != s.charAt(index)) {
                c = s.charAt(index);
                result[1] = 0;
            }
        }
        return result;
    }
}
