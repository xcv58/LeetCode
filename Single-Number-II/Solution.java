public class Solution {
    public int singleNumber(int[] A) {
        int first = 0;
        int second = 0;
        for (int tmpInt : A) {
            first = (first ^ tmpInt) & ~second;
            second = (second ^ tmpInt) & ~first;
        }
        return first;
    }
}
