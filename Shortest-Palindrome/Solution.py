class Solution:
    # @param {string} s
    # @return {string}
    def shortestPalindrome(self, s):
        if not s or len(s) == 1:
            return s
        j = 0
        for i in reversed(range(len(s))):
            if s[i] == s[j]:
                j += 1
        return s[::-1][:len(s)-j] + self.shortestPalindrome(s[:j-len(s)]) + s[j-len(s):]
