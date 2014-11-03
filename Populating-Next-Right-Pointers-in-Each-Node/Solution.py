# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        while root is not None:
            anchor = root
            while anchor is not None:
                if anchor.left is not None:
                    anchor.left.next = anchor.right
                    if anchor.next is None:
                        break
                    anchor.right.next = anchor.next.left
                anchor = anchor.next
            root = root.left;
