# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # @param root, a tree node
    # @return an integer
    maxResult = 0
    def maxPathSum(self, root):
        Solution.maxResult = root.val
        self.privateMaxPathSum(root)
        return Solution.maxResult

    def privateMaxPathSum(self, root):
        if root is None:
            return 0

        left = root.val + self.privateMaxPathSum(root.left)
        right = root.val + self.privateMaxPathSum(root.right)

        localmax = max(root.val, left, right)
        sum = left + right - root.val
        Solution.maxResult = max(localmax, sum, Solution.maxResult)

        return localmax
