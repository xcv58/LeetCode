import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0, low = Integer.MAX_VALUE; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }
}
