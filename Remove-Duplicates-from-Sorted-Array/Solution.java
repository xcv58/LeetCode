public class Solution {
    public int removeDuplicates(int[] A) {
        int anchor = 0;

        for (int i = 0; i < A.length; i++, anchor++) {
            for (; i + 1 < A.length && A[i] == A[i+1]; i++);
            if (i + 1 < A.length) {
                A[anchor + 1] = A[i + 1];
            }
        }
        return anchor;
    }
}
