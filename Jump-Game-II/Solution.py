class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        cache = [0] * len(A)
        reach = 1
        for i in range(len(A)):
            last = i + A[i] + 1
            if last > reach:
                for j in range(reach, min(last, len(cache))):
                    cache[j] = cache[i] + 1
                reach = last
        return cache[-1]
