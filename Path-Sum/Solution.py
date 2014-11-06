# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a boolean
    def hasPathSum(self, root, sum):
        if root is None:
            return False
        if root.left is None and root.right is None:
            return root.val == sum
        return True if (False if root.left is None else self.hasPathSum(root.left, sum - root.val)) else (False if root.right is None else self.hasPathSum(root.right, sum - root.val))
