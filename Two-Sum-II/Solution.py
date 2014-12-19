class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        i = 0
        j = len(num) - 1
        while i < j:
            gap = num[i] + num[j] - target
            if gap == 0:
                return [i + 1, j + 1]
            i = i if gap > 0 else i + 1
            j = j - 1 if gap > 0 else j
        return [-1, -1]
