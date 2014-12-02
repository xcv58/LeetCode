class Solution:
    # @param s, a string
    # @param t, a string
    # @return a boolean
    def isOneEditDistance(self, s, t):
        ls = len(s)
        lt = len(t)
        if abs(ls - lt) > 1:
            return False
        si = 0
        ti = 0
        while si < ls and ti < lt:
            if s[si] != t[ti]:
                return s[si + (1 if ls -si >= lt - ti else 0):] == t[ti + (1 if ls -si <= lt - ti else 0):]
            si += 1
            ti += 1
        return abs(ls - si - lt + ti) == 1
