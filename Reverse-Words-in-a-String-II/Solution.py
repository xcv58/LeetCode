class Solution:
    # @param s, a list of 1 length strings, e.g., s = ['h','e','l','l','o']
    # @return nothing
    def reverseWords(self, s):
        index = [i for i, x in enumerate(s) if x == ' ']
        for x, y in zip([-1] + index + [-1], index + [len(s)] * 2):
            s[x+1:y] = s[x+1:y][::-1]
