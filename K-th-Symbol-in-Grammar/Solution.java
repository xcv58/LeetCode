class Solution {
    public int kthGrammar(int N, int K) {
        if (K == 1) {
            return 0;
        }
        int anchor = 1;
        while (anchor < K) {
            anchor *= 2;
        }
        return 1 ^ this.kthGrammar(N, K - (anchor / 2));
    }
}
