# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param p, a tree node
    # @param q, a tree node
    # @return a boolean
    def isSameTree(self, p, q):
        return p == q if p is None or q is None else p.val == q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
