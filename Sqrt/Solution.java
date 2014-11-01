public class Solution {
    public int sqrt(int x) {
        int root = 1;
        int tmpInt = x;

        while (tmpInt > root) {
            root = root << 1;
            tmpInt = tmpInt >> 1;
        }

        for (int tmpResult, mid = (root + tmpInt) / 2; tmpInt +1 < root; mid = (root + tmpInt) / 2) {
            tmpResult = x / mid;
            if (tmpResult == mid) {
                return mid;
            } else if (tmpResult > mid) {
                tmpInt = mid;
            } else {
                root = mid;
            }
        }
        return tmpInt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{0, 1, 2, 3, 100, 1024, 65536, 1579205274, 2147483647};
        for (int tmpInt : arr) {
            System.out.println(tmpInt + ": " + s.sqrt(tmpInt));
        }
    }
}
