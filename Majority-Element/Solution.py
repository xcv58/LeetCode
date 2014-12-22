class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        index = 0
        count = 1
        for i in range(len(num)):
            count += 1 if num[index] == num[i] else -1
            if count == 0:
                index = i
                count = 1
        return num[index]
