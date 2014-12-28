public class Solution {
    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                num[i] += num[j] * num[i - 1 - j];
            }
        }

        return num[n];
    }
}
