class Solution {
public:
    void reverseWords(string &s) {
        for (int i = 0, j = 0; i < s.size(); i++) {
            for (j = i; i < s.size() && !isblank(s[i]); i++);
            reverse(s.begin() + j, s.begin() + i);
        }
        reverse(s.begin(), s.end());
    }
};
