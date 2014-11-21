# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def inorderTraversal(self, root):
        result = []
        stack = []

        while len(stack) > 0 or root is not None:
            if root is not None:
                stack.append(root)
                root = root.left
            elif len(stack) > 0:
                root = stack.pop()
                result.append(root.val)
                root = root.right
        return result
