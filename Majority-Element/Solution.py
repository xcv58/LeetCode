class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        return sorted(num)[len(num) / 2]
