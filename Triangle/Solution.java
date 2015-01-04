import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[] result = triangle.get(triangle.size() - 1).toArray(new Integer[triangle.size()]);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j + 1]);
            }
        }
        return result[0];
    }
}
