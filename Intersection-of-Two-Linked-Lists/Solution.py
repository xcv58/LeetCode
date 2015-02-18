# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        s = set()
        while headA is not None:
            s.add(headA)
            headA = headA.next
        while headB is not None:
            if headB in s:
                return headB
            headB = headB.next
        return None
