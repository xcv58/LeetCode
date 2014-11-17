public class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int[] candyNum = new int[size];
        int result = size;

        for (int i = 0; i < size; i++) {
            this.check(ratings, candyNum, i);
        }

        for (int i = size - 1; i >= 0; i--) {
            this.check(ratings, candyNum, i);
            result += candyNum[i];
        }

        return result;
    }

    private void check(int[] ratings, int[] candyNum, int i) {
        this.check(ratings, candyNum, i, i - 1);
        this.check(ratings, candyNum, i, i + 1);
    }

    private void check(int[] ratings, int[] candyNum, int i, int j) {
        candyNum[i] = (j >= 0 && j < candyNum.length) && ratings[i] > ratings[j] && candyNum[i] <= candyNum[j] ? candyNum[j] + 1 : candyNum[i];
    }
}
