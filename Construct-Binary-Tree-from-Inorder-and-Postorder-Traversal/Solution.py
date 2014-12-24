# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param inorder, a list of integers
    # @param postorder, a list of integers
    # @return a tree node
    def buildTree(self, inorder, postorder):
        return self.buildTreeInner(inorder, 0, len(inorder), postorder, 0, len(postorder))

    def buildTreeInner(self, inorder, ini, inj, postorder, posti, postj):
        if posti >= postj:
            return None
        root = TreeNode(postorder[postj - 1])
        leftLength = self.indexOf(postorder[postj - 1], inorder, ini, inj);
        if leftLength != -1:
            root.left = self.buildTreeInner(inorder, ini, ini + leftLength, postorder, posti, posti + leftLength)
            root.right = self.buildTreeInner(inorder, ini + leftLength + 1, inj, postorder, posti + leftLength, postj - 1)
        return root

    def indexOf(self, target, nums, i, j):
        for index in range(i, j):
            if target == nums[index]:
                return index - i
        return -1
