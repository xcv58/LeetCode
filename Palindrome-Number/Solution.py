class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        update = 0
        while update < x:
            tmp = 10 * update + x % 10
            if tmp == update:
                return False
            if tmp == x:
                return True
            update = tmp
            x /= 10
        return update == x
