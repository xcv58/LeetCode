# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        anchor = head
        base = head
        while anchor is not None and base is not None:
            if base.val == anchor.val:
                base.next = anchor.next
            else:
                base = anchor
            anchor = anchor.next
        return head
