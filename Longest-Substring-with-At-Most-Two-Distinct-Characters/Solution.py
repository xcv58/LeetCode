class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLongestSubstringTwoDistinct(self, s):
        result = 0
        for i in xrange(len(s)):
            result = max(self.getLength(s, i), result)
        return result

    def getLength(self, s, i):
        hashSet = set()
        result = 0
        for index in xrange(i, len(s)):
            hashSet.add(s[index])
            if len(hashSet) > 2:
                return result
            result += 1
        return result
