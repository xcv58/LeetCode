public class Solution {
    public int findPeakElement(int[] num) {
        for (int i = 0, j = num.length - 1, mid = j / 2; i < j; mid = (i + j) / 2) {
            if (mid == i) {
                return num[mid] > num[j] ? mid : j;
            }
            i = num[mid] < num[mid + 1] ? mid : i;
            j = num[mid] > num[mid + 1] ? mid : j;
        }
        return 0;
    }
}
