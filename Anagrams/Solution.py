class Solution:
    # @param strs, a list of strings
    # @return a list of strings
    def anagrams(self, strs):
        count = collections.Counter([tuple(sorted(str)) for str in strs])
        return filter(lambda x: count[tuple(sorted(x))] > 1, strs)
