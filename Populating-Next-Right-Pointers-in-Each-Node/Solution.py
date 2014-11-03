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
        tmpRoot = root
        while tmpRoot is not None:
            tmpAnchor = tmpRoot
            self.connectChildren(tmpAnchor)
            while tmpAnchor.next is not None:
                if tmpAnchor.left is not None:
                    tmpAnchor.right.next = tmpAnchor.next.left;
                tmpAnchor = tmpAnchor.next
                self.connectChildren(tmpAnchor)
            tmpRoot = tmpRoot.left;

    def connectChildren(self, root):
        if root.left is not None:
            root.left.next = root.right
