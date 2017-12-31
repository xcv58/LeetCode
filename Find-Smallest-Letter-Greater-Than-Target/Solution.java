class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // TODO: How to handle letters is null?
        int i = 0;
        int j = letters.length;
        while (i < j) {
            int mid = (j - i) / 2 + i;
            if (letters[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (i >= letters.length) {
            return letters[0];
        }
        return letters[i];
    }
}
