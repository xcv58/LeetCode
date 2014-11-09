class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        tmpNum = list(num)
        tmpNum.sort()
        i = 0
        j = len(tmpNum) - 1
        while i < j:
            sum = tmpNum[i] + tmpNum[j]
            if sum == target:
                num1 = tmpNum[i]
                num2 = tmpNum[j]
                break
            if sum > target:
                j = j - 1
            else:
                i = i + 1

        i = 0
        result = []
        while i < len(num):
            if num1 == num[i] or num2 == num[i]:
                result.append(i + 1)
            i = i + 1
        return result
