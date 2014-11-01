class Solution:
    # @param x, an integer
    # @return an integer
    def sqrt(self, x):
        root = 1;
        tmpInt = x;

        while tmpInt > root:
            root = root << 1
            tmpInt = tmpInt >> 1

        mid = (root + tmpInt) / 2
        while tmpInt +1 < root:
            tmpResult = x / mid;
            if tmpResult == mid:
                return mid
            elif tmpResult > mid:
                tmpInt = mid
            else:
                root = mid
            mid = (root + tmpInt) / 2
        return tmpInt
