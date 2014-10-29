public class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int tmpInt : A) {
            result ^= tmpInt;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int A[] = {1, 2, 2, 3, 1};
        int result = s.singleNumber(A);
        System.out.println(result);
    }
}
