class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        i = 0
        j = len(num) - 1
        while num[i] > num[j]:
            mid = (i + j) // 2
            if num[mid] > num[i]:
                i = mid
            elif num[mid] < num[i]:
                j = mid
            else:
                return num[j]
        return num[i]
