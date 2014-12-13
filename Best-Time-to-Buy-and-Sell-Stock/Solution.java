import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0, anchor = 0, len = prices.length; i < len; i++) {
            for (; i + 1 < len && prices[i + 1] <= prices[i]; i++);
            anchor = (prices[i] < prices[anchor]) ? i : anchor;
            for (; i + 1 < len && prices[i + 1] >= prices[i]; i++);
            max = prices[i] - prices[anchor] > max ? prices[i] - prices[anchor] : max;
        }
        return max;
    }
}
