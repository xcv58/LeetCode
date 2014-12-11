class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        l = filter(lambda x: x not in set(['.', '@', '-', '?', '"', '!', '(', ')', '`', ';', ' ', '?', '#', ':', ',', '\'']), list(s.lower()))
        return l == list(reversed(l))
