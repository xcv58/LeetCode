class Solution:
    # @return a string
    def convertToTitle(self, num):
        return "" if num == 0 else self.convertToTitle((num - 1) / 26) + chr((num - 1) % 26 + 65)
