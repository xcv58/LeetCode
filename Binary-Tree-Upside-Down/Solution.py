# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return root of the upside down tree
    def upsideDownBinaryTree(self, root):
        stack = []
        while root is not None:
            stack.append(root)
            root = root.left
        anchor = stack.pop() if len(stack) > 0 else None
        root = anchor
        while len(stack) > 0 and anchor is not None:
            anchor.right = stack.pop()
            anchor.left = anchor.right.right
            anchor = anchor.right
            anchor.left = None
            anchor.right =None
        return root
