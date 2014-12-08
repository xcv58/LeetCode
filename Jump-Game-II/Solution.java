public class Solution {
    public int jump(int[] A) {
        int[] cache = new int[A.length];
        for (int i = 0, reach = 1; i < A.length; i++) {
            int last = i + A[i] + 1;
            if (last > reach) {
                for (int j = reach; j < last && j < cache.length; cache[j] = cache[i] + 1, j++);
                reach = last;
            }
        }
        return cache[A.length - 1];
    }
}
