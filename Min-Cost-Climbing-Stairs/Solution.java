class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            return 0;
        }
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i = 2; i <= cost.length; i++) {
            i3 = Math.min(i1 + cost[i - 2], i2 + cost[i - 1]);
            i1 = i2;
            i2 = i3;
        }
        return i3;
    }
}
