class Solution:
    # @return a boolean
    def isValid(self, s):
        stack = []
        for i in range(len(s)):
            c = s[i]
            if self.isLeft(c):
                stack.append(c)
                continue
            if not stack or self.notMatch(stack.pop(), c):
                return False
        return not stack

    def isLeft(self, c):
        return c == '(' or c == '{' or c == '['

    def notMatch(self, c, d):
        return not ((c == '(' and d == ')') or (c == '{' and d == '}') or (c == '[' and d == ']'));
