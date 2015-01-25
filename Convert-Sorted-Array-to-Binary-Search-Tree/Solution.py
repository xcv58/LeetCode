# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param num, a list of integers
    # @return a tree node
    def sortedArrayToBST(self, num):
        return self.innerSortedArrayToBST(num, 0, len(num))

    def innerSortedArrayToBST(self, num, start, end):
        if start + 1 >= end:
            return TreeNode(num[start]) if start + 1 == end else None

        mid = (start + end) / 2
        root = TreeNode(num[mid])
        root.left = self.innerSortedArrayToBST(num, start, mid)
        root.right = self.innerSortedArrayToBST(num, mid + 1, end)

        return root
