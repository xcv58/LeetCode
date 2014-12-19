public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1, gap; i < j; j = gap > 0 ? j - 1 : j, i = gap > 0 ? i : i + 1) {
            gap = numbers[i] + numbers[j] - target;
            if (gap == 0) { return new int[]{i + 1, j + 1}; }
        }
        return new int[]{-1, -1};
    }
}
