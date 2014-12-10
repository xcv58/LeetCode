class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        i = 0
        j = len(num) - 1
        while i < j:
            if num[i] < num[j]:
                return num[i]
            mid = (i + j) // 2
            if num[mid] > num[j]:
                i = mid + 1
            elif num[mid] == num[j]:
                i = i + 1
                j = j - 1
            else:
                j = mid
        return num[i]
