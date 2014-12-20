class Solution:
    # @return a string
    def convertToTitle(self, num):
        result = []
        while num != 0:
            result.append((num - 1) % 26)
            num = (num - 1) / 26
        return ''.join([chr(x + 65) for x in reversed(result)])
