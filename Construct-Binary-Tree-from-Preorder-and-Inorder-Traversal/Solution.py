# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param preorder, a list of integers
    # @param inorder, a list of integers
    # @return a tree node
    def buildTree(self, preorder, inorder):
        return self.buildTreeInner(preorder, 0, len(preorder), inorder, 0, len(inorder))

    def buildTreeInner(self, preorder, prei, prej, inorder, ini, inj):
        if prei >= prej:
            return None
        root = TreeNode(preorder[prei])
        leftLength = self.indexOf(preorder[prei], inorder, ini, inj);
        if leftLength != -1:
            root.left = self.buildTreeInner(preorder, prei + 1, prei + 1 + leftLength, inorder, ini, ini + leftLength)
            root.right = self.buildTreeInner(preorder, prei + leftLength + 1, prej, inorder, ini + leftLength + 1, inj)
        return root

    def indexOf(self, target, nums, i, j):
        for index in range(i, j):
            if target == nums[index]:
                return index - i
        return -1
