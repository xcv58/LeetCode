# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a list of lists of integers
    def pathSum(self, root, sum):
        lists = []

        if root is None:
            return lists

        if root.left is None and root.right is None:
            if root.val==sum:
                return [[root.val]]
            else:
                return lists

        list = self.pathSum(root.left, sum - root.val) + self.pathSum(root.right, sum-root.val)
        map(lambda x : x.insert(0, root.val), list)
        lists.extend(list)

        return lists
