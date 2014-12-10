import java.util.*;

public class Solution {
    public int findMin(int[] num) {
        int i = 0;
        for (int j = num.length - 1, mid = (i + j) / 2; i < j; mid = (i + j) / 2) {
            if (num[i] < num[j]) {
                break;
            }
            if (num[mid] > num[j]) {
                i = mid + 1;
            } else if (num[mid] == num[j]) {
                i++;
                j--;
            } else {
                j = mid;
            }
        }
        return num[i];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12345
        // 23451
        // 34512
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{1});
        list.add(new int[]{3, 1, 3});
        list.add(new int[]{1, 1, 1, 4, 5});
        list.add(new int[]{2, 3, 1, 1, 1});
        list.add(new int[]{2, 2, 2, 1, 2});
        for (int[] arr : list) {
            System.out.println(s.findMin(arr));
        }
        return;
    }
}
