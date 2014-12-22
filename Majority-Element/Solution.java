public class Solution {
    public int majorityElement(int[] num) {
        int index = 0;
        for (int count = 1, i = 0; i < num.length; i++, count = Math.max(count, 1)) {
            count += num[index] == num[i] ? 1 : -1;
            index = count == 0 ? i : index;
        }
        return num[index];
    }
}
