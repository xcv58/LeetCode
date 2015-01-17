# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isBalanced(self, root):
        return root is None or self.innerIsBalanced(root.left, root.right, 1) >= 0

    def innerIsBalanced(self, left, right, depth):
        lResult = depth if left is None else self.innerIsBalanced(left.left, left.right, depth + 1)
        rResult = depth if right is None else self.innerIsBalanced(right.left, right.right, depth + 1)
        return -depth if min(lResult, rResult) < 0 or abs(lResult - rResult) > 1 else max(lResult, rResult)
