import java.util.*;

public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> missList = new ArrayList<String>();

        for (int i = 0, previous = lower - 1, current = upper; i <= A.length; i++, previous = current) {
            current = (i == A.length) ? upper + 1 : A[i];
            if (current - previous >= 2) {
                missList.add(this.getStr(previous + 1, current - 1));
            }
        }

        return missList;
    }

    private String getStr(int i, int j) {
        return i == j ? Integer.toString(i) : i + "->" + j;
    }
}
