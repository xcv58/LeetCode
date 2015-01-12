class Solution:
    # @param an integer
    # @return a list of string
    def generateParenthesis(self, n):
        list = []
        if n == 1:
            list.append("()")
        if n <= 1:
            return list

        for i in xrange(n - 1):
            leftList = self.generateParenthesis(i)
            rightList = self.generateParenthesis(n - i - 1)
            for left in leftList:
                for right in rightList:
                    list.append("(" + left + ")" + right)
        tmpList = self.generateParenthesis(n - 1)
        for tmpStr in tmpList:
            list.append("(" + tmpStr + ")")
            list.append("()" + tmpStr)
        return list;
