class Solution:
    # @param A, a list of integers
    # @param lower, an integer
    # @param upper, an integer
    # @return a list of strings
    def findMissingRanges(self, A, lower, upper):
        missList = []
        previous = lower - 1
        for i in range(len(A) + 1):
            current = upper + 1 if i == len(A) else A[i]
            if current - previous >= 2:
                missList.append(self.getStr(previous + 1, current - 1))
            previous = current
        return missList

    def getStr(self, i, j):
        return str(i) if i == j else str(i) + "->" + str(j)
