# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def preorderTraversal(self, root):
        result = []
        stack = [root]
        while len(stack) > 0:
            root = stack.pop()
            if root is not None:
                result.append(root.val)
                stack.append(root.right)
                stack.append(root.left)
        return result
