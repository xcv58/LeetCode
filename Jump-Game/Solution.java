public class Solution {
    public boolean canJump(int[] A) {
        int max = 1;
        for (int i = 0; i < max && max <= A.length; i++) {
            max = Math.max(i + 1 + A[i], max);
        }
        return max >= A.length;
    }
}
