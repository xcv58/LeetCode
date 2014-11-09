import java.util.*;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int[] tmpArray = numbers.clone();

        Arrays.sort(tmpArray);

        int num1 = 0;
        int num2 = 0;
        for (int i = 0, j = numbers.length - 1, sum; i < j;) {
            sum = tmpArray[i] + tmpArray[j];
            if (sum == target) {
                num1 = tmpArray[i];
                num2 = tmpArray[j];
                break;
            }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        for (int i = 0, j = 0; i < numbers.length && j < result.length; i++) {
            int tmpInt = numbers[i];
            if (tmpInt == num1 || tmpInt == num2) {
                result[j] = i + 1;
                j++;
            }
        }

        return result;
    }
}
